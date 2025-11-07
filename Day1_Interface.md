# 🧩 Java Interfaces — Handy Notes

## 🔍 What Is an Interface in Java?

In Java, the `abstract` keyword is used at the class level to make a class abstract.  
An **abstract class** can contain:
- Methods **without implementation** (called abstract methods)
- Methods **with implementation** (called concrete methods)

However, when a class has **only abstract methods**, we can use an **interface** instead of an abstract class to achieve **100% abstraction**.

---

## 🧠 What Is an Interface?

An **interface** in Java is a **blueprint of a class** that can contain:
- **Static constants**
- **Abstract methods**

It is mainly used to achieve **abstraction** and **multiple inheritance**.

### ✳️ Key Points
- Interfaces cannot have method bodies — they only declare methods.
- You cannot instantiate an interface directly (similar to abstract classes).
- Methods declared in an interface are **public** and **abstract** by default.
- Variables in an interface are **public**, **static**, and **final** by default.

---

## 🌟 Key Features of an Interface

| Feature | Description |
|----------|-------------|
| **Total Abstraction** | All methods in an interface are abstract — the implementing class must provide implementations. |
| **IS-A Relationship** | Represents the “IS-A” relationship (like inheritance). |
| **`implements` Keyword** | Used by a class to indicate it provides implementations for the interface methods. |
| **Static & Final Variables** | Variables in an interface are static and final by default — they are constants. |

---

## 🧩 Syntax of an Interface

To declare an interface, use the `interface` keyword.

```java
interface InterfaceName {
    // Constant declaration
    int VALUE = 10;

    // Abstract method declaration
    void display();
}


# 🧩 10.7 — More on Interfaces

In previous sections, we've explored interfaces in Java in depth.  
Now, let’s dive into **more advanced topics** regarding interfaces.

---

## 💡 Can a Class Implement Multiple Interfaces?

A common question is:  
> Can a class implement multiple interfaces?

✅ **Yes, it can.**

In Java:
- A **class can implement multiple interfaces**.
- But a **class can extend only one class**.

This allows for **more flexible and modular design** in Java programs.

---

## 🧩 Multiple Interface Implementation — Example

```java
interface A {
    int age = 44;
    String area = "Bangalore";

    void show();
    void config();
}

interface X {
    void run();
}

interface Y {
    // Empty interface — also called a Marker Interface
}

class B implements A, X {
    public void show() {
        System.out.println("In show");
    }

    public void config() {
        System.out.println("In config");
    }

    public void run() {
        System.out.println("In run");
    }
}

public class Demo {
    public static void main(String[] args) {
        B obj = new B();
        obj.show();
        obj.config();
        obj.run();

        // Accessing interface variables
        System.out.println(A.age);
        System.out.println(A.area);
    }
}

# 🧩 10.6 — Need of Interface

In this section, we’ll explore the **importance of interfaces in Java** and understand their usage with examples.  
Interfaces play a crucial role in achieving **abstraction**, **flexibility**, and adhering to design principles like:

> **“Programming to an interface, not an implementation.”**

---

## 🧠 Initial Scenario: Without Interface

Consider the following example:

```java
class Laptop {
    public void code() {
        System.out.println("Code, compile, and run");
    }
}

class Desktop {
    public void code() {
        System.out.println("Code, compile, and run... faster");
    }
}

class Developer {
    public void devApp(Laptop laptop) {
        laptop.code();
    }
}

public class Demo {
    public static void main(String[] args) {
        Laptop lap = new Laptop();
        Desktop desk = new Desktop();
        Developer dev = new Developer();

        dev.devApp(lap); // Developer uses Laptop to code
    }
}
```

---

### 🧾 Explanation

In this example, there are **three main classes**:

1. **Laptop** – Represents a laptop that can run code.  
2. **Desktop** – Represents a desktop that runs code faster than a laptop.  
3. **Developer** – Represents a developer who uses a device (either Laptop or Desktop) to write and run code.

The `Developer` class has a method:

```java
public void devApp(Laptop laptop)
```
which takes a **Laptop** object as a parameter and calls its `code()` method.  

In the `Demo` class, we instantiate the **Laptop**, **Desktop**, and **Developer** classes, and pass the Laptop object to the developer.

---

## ⚠️ Problem

Initially, the developer works with a **Laptop**.  
But later, if the company decides to provide a **Desktop**, changes must be made to the `Developer` class to accommodate it.

This violates **flexibility** in design.  
Each time a new type of computer (e.g., Tablet, Server) is introduced, we would have to **modify the Developer class**.

This goes against the **Open/Closed Principle (OCP)** —  
> “Software entities should be open for extension, but closed for modification.”

This is where **interfaces** come into play.

---

## 🧩 Solution 1 — Using Abstraction

One possible improvement is to use **abstraction** to generalize both `Laptop` and `Desktop`.  
Both are types of **computers**, so we can introduce an **abstract class** called `Computer`.

---

### 💻 Example — Using Abstract Class

```java
abstract class Computer {
    public abstract void code();
}

class Laptop extends Computer {
    public void code() {
        System.out.println("Code, compile, and run");
    }
}

class Desktop extends Computer {
    public void code() {
        System.out.println("Code, compile, and run... faster");
    }
}

class Developer {
    public void devApp(Computer comp) {
        comp.code();
    }
}

public class Demo {
    public static void main(String[] args) {
        Computer lap = new Laptop();
        Computer desk = new Desktop();
        Developer dev = new Developer();

        dev.devApp(lap);
        dev.devApp(desk);
    }
}
```

---

### 🧾 Explanation

- We created an **abstract class** `Computer` with an abstract method `code()`.  
- Both `Laptop` and `Desktop` **extend** `Computer` and implement the `code()` method differently.  
- The `Developer` class now works with the **Computer type**, not specific device types.

This makes the developer’s code **flexible** — the same `Developer` class can now work with **any computer type**.

---

### 🖥️ Output

```
Code, compile, and run
Code, compile, and run... faster
```

---

### ✅ Advantages of This Approach

- The developer can work with any **Computer** (Laptop, Desktop, etc.).  
- The `Developer` class is now **decoupled** from specific devices.  
- Improves **flexibility**, **maintainability**, and **reusability**.

---

### ⚠️ Issue with Abstract Classes

Although better, **abstract classes only provide partial abstraction**.

Reasons:
- We can still include **non-abstract methods** (with implementation).
- If we require **complete abstraction** (method declarations only), we need **interfaces**.

---

## 🧩 Solution 2 — Using Interface (Better Solution)

Interfaces provide a **higher level of abstraction**.  
They allow us to declare **methods without implementation**, and classes that implement them must define the method bodies.

Let’s modify our example to use an **interface** instead of an abstract class.

---

### 💻 Example — Using Interface

```java
interface Computer {
    void code();
}

class Laptop implements Computer {
    public void code() {
        System.out.println("Code, compile, and run");
    }
}

class Desktop implements Computer {
    public void code() {
        System.out.println("Code, compile, and run... faster");
    }
}

class Developer {
    public void devApp(Computer comp) {
        comp.code();
    }
}

public class Demo {
    public static void main(String[] args) {
        Computer lap = new Laptop();
        Computer desk = new Desktop();
        Developer dev = new Developer();

        dev.devApp(lap);
        dev.devApp(desk);
    }
}
```

---

### 🖥️ Output

```
Code, compile, and run
Code, compile, and run... faster
```

---

## 🧠 Why Use Interfaces?

### 🔹 Full Abstraction
All methods in an interface are **abstract by default** (prior to Java 8).  
Implementing classes **must** provide their own method bodies.

This ensures **maximum flexibility** and **decoupling**.

---

### 🔹 Decoupling
The `Developer` class now depends only on the **Computer interface**, not on specific implementations like `Laptop` or `Desktop`.  
This makes the code more **modular**, **extensible**, and **reusable**.

---

### 🔹 Flexibility
If a new device (say, `Tablet`) is added later, the `Developer` class **does not change** — it can work with any object implementing the `Computer` interface.

---

### 🧩 Example — Adding a New Class

```java
class Tablet implements Computer {
    public void code() {
        System.out.println("Code, compile, and run... on Tablet");
    }
}

public class Demo {
    public static void main(String[] args) {
        Computer tab = new Tablet();
        Developer dev = new Developer();

        dev.devApp(tab);
    }
}
```

**Output:**
```
Code, compile, and run... on Tablet
```

> 🔸 The `Developer` class remains unchanged — it works with all future `Computer` types automatically.

---

## ✅ Conclusion

By using an **interface**, we achieve:

- **Full abstraction** (no implementation in the interface).
- **Loose coupling** between classes.
- **Reusability** — new device types can be added easily.
- **Maintainability** — the `Developer` class never needs to be modified.

Thus, interfaces help us follow **solid design principles**, especially:

> 🧩 **Program to an interface, not to an implementation.**

---

## 🧭 Summary

| Concept | Abstract Class | Interface |
|----------|----------------|------------|
| Level of Abstraction | Partial | Full |
| Can Have Concrete Methods | ✅ Yes | ❌ No (before Java 8) |
| Supports Multiple Inheritance | ❌ No | ✅ Yes |
| Variables | Can be any type | Always `public static final` |
| Methods | Can be abstract or concrete | Always `public abstract` (by default) |
| Implementation Keyword | `extends` | `implements` |
| Used For | Shared behavior with partial abstraction | 100% abstraction and flexibility |

---

# 🏁 End of Notes — Need of Interface
