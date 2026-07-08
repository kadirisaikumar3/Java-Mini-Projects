# 📝 Notes Manager

A Java console-based application that allows users to create, view, search, and delete notes using **File Handling** and **Object-Oriented Programming (OOP)**. Notes are stored permanently in a text file, ensuring they remain available even after the application is closed.

---

## ✨ Features

- ➕ Add Note
- 👀 View Notes
- 🔍 Search Note
- ❌ Delete Note
- 💾 Save Notes to File
- 📂 Persistent Data Storage
- 🖥️ Menu-Driven Interface

---

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- File Handling
- FileWriter
- FileReader
- BufferedWriter
- BufferedReader
- Exception Handling
- VS Code

---

## 📁 Project Structure

```text
15-Notes-Manager
│
├── Note.java
├── NotesManager.java
├── notes.txt
└── README.md
```

---

## 🚀 How to Run

Compile the program:

```bash
javac Note.java NotesManager.java
```

Run the program:

```bash
java NotesManager
```

---

## 📋 Sample Menu

```text
========== NOTES MANAGER ==========

1. Add Note
2. View Notes
3. Search Note
4. Delete Note
5. Exit
```

---

## 📂 Sample Data (notes.txt)

```text
101,Shopping,Buy Milk and Bread
102,Interview,Practice Java OOP
103,Reminder,Update GitHub Repository
```

Each note follows this format:

```text
NoteID,Title,Content
```

---

## 🎯 Concepts Practiced

- Classes & Objects
- Constructors
- File Handling
- FileWriter
- FileReader
- BufferedReader
- BufferedWriter
- Exception Handling
- File-Based CRUD Operations
- Persistent Storage
- Menu-Driven Programming

---

## 📚 Learning Outcomes

After completing this project, I learned how to:

- Store notes permanently in a text file.
- Read notes efficiently using `BufferedReader`.
- Append new notes using `FileWriter`.
- Delete records using a temporary file.
- Implement CRUD operations with file storage.
- Handle file-related exceptions using `try-catch`.

---

## 🔮 Future Improvements

- Edit Existing Notes
- Search by Title
- Add Date & Time
- Export Notes
- Encrypt Notes
- Store Notes in a Database

---

## 👨‍💻 Author

**Sai Kumar**

Aspiring Software Engineer | Java Developer | Google SDE-1 Preparation

GitHub:
https://github.com/kadirisaikumar3

---

⭐ If you found this project helpful, consider giving this repository a star!