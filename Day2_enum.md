# 🧩 Java Enum — Handy Notes

## 📘 10.8 What is Enum

### 🔹 Definition
An **Enum (enumeration)** in Java is a special data type that contains a fixed set of constants.  
Useful when a variable can take **only one of a predefined set of values**.

### 🧠 Common Examples
- Days of the week → `SUNDAY, MONDAY, TUESDAY, ...`
- Directions → `NORTH, SOUTH, EAST, WEST`
- Status codes → `RUNNING, FAILED, SUCCESS`

### 🧩 Real-World Example
Websites return error codes like:
- `404 Page Not Found`
- `500 Internal Server Error`

Similarly, Java enums define constants like:
```java
enum Status {
    RUNNING, FAILED, PENDING, SUCCESS
}
```

### 🧑‍💻 Example Usage
```java
public class Test {
    enum Status { RUNNING, FAILED, PENDING, SUCCESS }

    public static void main(String[] args) {
        Status s = Status.RUNNING;
        System.out.println(s); // Output: RUNNING
    }
}
```

### ⚙️ Characteristics of Enums
- Enum constants are **public, static, final**
- Enums are **object-oriented** → can have **constructors, methods, variables**
- Constants have implicit **index/order (starting at 0)**

### 🧩 Built-in Enum Methods
1. **`ordinal()`**
   - Returns the index of an enum constant  
     ```java
     System.out.println(Status.RUNNING.ordinal()); // 0
     ```

2. **`values()`**
   - Returns an array of all enum constants  
     ```java
     for (Status s : Status.values())
         System.out.println(s);
     ```

### 🏁 Conclusion
Enums make code more **readable, maintainable, and organized**.  
They behave like classes with extra features for handling **constant sets**.

---

## 📗 10.9 Enum with If and Switch

### 🔹 Key Features of Enums
- Enum constants are **public, static, final**
- Accessible using dot (`.`) syntax
- Can have **attributes** and **methods**
- Cannot **inherit other classes**
- Can **implement interfaces**
- Can be compared using **`==`**, **`if-else`**, or **`switch`**

### 🧑‍💻 Example Enum
```java
enum Status {
    RUNNING, FAILED, PENDING, SUCCESS
}
```

### 🧩 Using Enum with if-else
```java
Status s = Status.RUNNING;

if (s == Status.RUNNING)
    System.out.println("All good");
else if (s == Status.FAILED)
    System.out.println("Error occurred");
else
    System.out.println("Unknown status");
```

### 🧩 Using Enum with Switch
```java
switch (s) {
    case RUNNING:
        System.out.println("All good");
        break;
    case FAILED:
        System.out.println("Error occurred");
        break;
    case PENDING:
        System.out.println("Still in progress");
        break;
    case SUCCESS:
        System.out.println("Task completed");
        break;
}
```

### ⚙️ Switch Statement Summary
- Compares a variable with multiple cases  
- Uses `break` to exit after a match  
- **Cleaner and more readable** than multiple if-else blocks

### ✅ Advantages of Switch with Enums
- **Readability** → Easier to understand multiple conditions  
- **Clarity** → Avoids clutter from many else-if statements  
- **Efficiency** → Designed for discrete value comparisons

---

## 📙 10.10 Enum Class — Constructors, Methods & Inheritance

### 🔹 Enum Basics
Enums are special classes that:
- Cannot be extended
- Can contain:
  - **Methods**
  - **Constructors**
  - **Variables**

### 🧩 Enum and Inheritance
- All enums implicitly **extend `java.lang.Enum`**
- Cannot extend any other class (no multiple inheritance)
- Enums can **implement interfaces**
- `toString()` is overridden in `Enum` → returns constant’s name

### 🧱 Enum Constructors
- Enum constructors are **always private**
- They run **once per constant** when the enum is loaded
- You **cannot use `new`** to create enum objects

#### 🧩 Parameterized Constructor Example
```java
enum Laptop {
    MACBOOK(2000),
    XPS(1800),
    SURFACE(1500),
    THINKPAD(1200);

    private int price;

    private Laptop(int price) {  // constructor
        this.price = price;
    }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
```

#### 💡 Example Usage
```java
public class Test {
    public static void main(String[] args) {
        for (Laptop l : Laptop.values())
            System.out.println(l + " : " + l.getPrice());
    }
}
```

### ⚙️ Output
```
MACBOOK : 2000
XPS : 1800
SURFACE : 1500
THINKPAD : 1200
```

### 🧠 Key Points
1. If you define a parameterized constructor → **all constants must have values**
2. Enum constructors are **private by default**
3. You can define **user methods (concrete or abstract)**

---

## 🏁 Quick Recap

| Concept | Description |
|----------|--------------|
| **Enum** | Special type representing fixed constants |
| **Access Modifiers** | Public, static, and final |
| **Inheritance** | Implicitly extends `Enum` class |
| **Constructor** | Always private; can be parameterized |
| **Methods** | Can include both predefined (`values()`, `ordinal()`) and user-defined |
| **Switch/If Usage** | Can compare enum constants using `==`, `if-else`, or `switch` |
| **Implements Interface** | Yes |
| **Extends Other Class** | No |
