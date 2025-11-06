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
