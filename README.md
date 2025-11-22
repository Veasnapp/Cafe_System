# Java Swing (JForm) + MySQL (XAMPP)

---

## 📦 Requirements

- **NetBeans IDE**
- **Java JDK (8–21)**
- **XAMPP (MySQL + Apache)**

---

## 🚀 Step 1: Start MySQL with XAMPP

1. Open the **XAMPP Control Panel**
2. Click **Start** on **MySQL**
3. (Optional) Click **Start** on **Apache**
4. Click **Admin** to open **phpMyAdmin**
5. Click **New**
6. Enter a database name (example: `cafe`)
7. Click **Create**

---

## 🗄 Step 2: Create MySQL Table

1. Go to:
   ```
   cafe_system -> src -> dao
   ```
2. Run `tables.java` to automatically create all required tables.
3. If table creation fails:
   - Open `ConnectionProvider.java`
   - Make sure your database name, username, password, and XAMPP MySQL settings are correct.

---

## ▶ Step 3: Run the Project

1. Go to either:
   ```
   src/view/
   ```
   or
   ```
   src/cafeManagementSystem/
   ```
2. Run any main form (usually Login.java or Home.java)

---

## ✔ Done

Your Java JForm + MySQL project should now run properly.


