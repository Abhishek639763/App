import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String apiUrl = "https://opentdb.com/api.php?amount=5&category=18&type=multiple";

        try {
            // Load quiz from local JSON file
            String content = new String(Files.readAllBytes(Paths.get("quiz.json")), StandardCharsets.UTF_8);
            JSONObject jsonResponse = new JSONObject(content);
            JSONArray results = jsonResponse.getJSONArray("results");

            int score = 0;
            for (int i = 0; i < results.length(); i++) {
                JSONObject qObj = results.getJSONObject(i);
                String question = qObj.getString("question")
                        .replace("&quot;", "\"")
                        .replace("&#039;", "'");

                String correctAnswer = qObj.getString("correct_answer")
                        .replace("&quot;", "\"")
                        .replace("&#039;", "'");

                JSONArray incorrectAnswers = qObj.getJSONArray("incorrect_answers");
                List<String> options = new ArrayList<>();
                options.add(correctAnswer);
                for (int j = 0; j < incorrectAnswers.length(); j++) {
                    options.add(incorrectAnswers.getString(j)
                            .replace("&quot;", "\"")
                            .replace("&#039;", "'"));
                }
                Collections.shuffle(options);

                System.out.println("\nQ" + (i + 1) + ": " + question);
                for (int j = 0; j < options.size(); j++) {
                    System.out.println((char) ('A' + j) + ". " + options.get(j));
                }

                System.out.print("Your answer: ");
                String ans = sc.next().toUpperCase();

                if (ans.length() == 1 && ans.charAt(0) - 'A' >= 0 && ans.charAt(0) - 'A' < options.size()) {
                    if (options.get(ans.charAt(0) - 'A').equals(correctAnswer)) {
                        System.out.println("✅ Correct!");
                        score++;
                    } else {
                        System.out.println("❌ Wrong! Correct answer: " + correctAnswer);
                    }
                } else {
                    System.out.println("Invalid choice! Correct answer was: " + correctAnswer);
                }
            }

            System.out.println("\n===== QUIZ OVER =====");
            System.out.println("Your Score: " + score + "/" + results.length());

        } catch (Exception e) {
            System.out.println("Error fetching quiz: " + e.getMessage());
        }

        sc.close();
    }
}
