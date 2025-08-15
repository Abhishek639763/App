# Online Quiz App 

This is a console-based quiz application written in Java.  
It reads **Java-related quiz questions** from a local `quiz.json` file and displays them as multiple-choice questions to the user.  

---

## 📂 Project Structure
│── OnlineQuizApp.java # Java source code for the quiz
│── quiz.json # Quiz questions in JSON format
│── json-20230227.jar # JSON parsing library (org.json)
│── README.md # Project instructions

---

## 📋 Requirements
- Java JDK 8 or above installed
- Internet NOT required (questions are loaded from a local file)
- `json-20230227.jar` library (download here: https://repo1.maven.org/maven2/org/json/json/20230227/json-20230227.jar)

---

## 📥 Setup Instructions

1. **Download the JSON Library**
   - Go to [json-20230227.jar](https://repo1.maven.org/maven2/org/json/json/20230227/json-20230227.jar)
   - Save it inside the project folder (`App/`)

2. **Ensure Folder Contains**
OnlineQuizApp.java
quiz.json
json-20230227.jar
README.md

---

## ⚙ Compilation & Execution

### **Windows (CMD)**
```bash
cd C:\Users\abhis\Downloads\App
javac -cp ".;json-20230227.jar" OnlineQuizApp.java
java -cp ".;json-20230227.jar" OnlineQuizApp
Linux / Mac
bash
Copy code
cd ~/Downloads/App
javac -cp ".:json-20230227.jar" OnlineQuizApp.java
java -cp ".:json-20230227.jar" OnlineQuizApp

🎯 How it Works
Loads quiz questions from quiz.json

Displays 10 Java-related multiple-choice questions

You select an answer by typing A, B, C, or D

Shows if your answer is correct and displays your total score

📝 quiz.json Format
Example:
{
  "response_code": 0,
  "results": [
    {
      "category": "Java Programming",
      "type": "multiple",
      "difficulty": "easy",
      "question": "Which keyword is used to inherit a class in Java?",
      "correct_answer": "extends",
      "incorrect_answers": [
        "implements",
        "inherits",
        "instanceof"
      ]
    }
  ]
}
✅ Features
he program will load **10 multiple-choice Java programming questions** from the local `quiz.json` file.

You will answer each question in the console by typing `A`, `B`, `C`, or `D`.

For every question, it will tell you whether your answer is ✅ Correct or ❌ Wrong, and display the correct answer if needed.

At the end, it will show your **final score** out of 10.


📌 Notes
Make sure quiz.json is in the same folder as OnlineQuizApp.java

For new questions, just edit quiz.json and keep the same format


---

If you want, I can now **add this README.md into a ZIP** with your fixed `OnlineQuizApp.java` and `quiz.json` so you have a ready-to-run package.  
Do you want me to do that?
