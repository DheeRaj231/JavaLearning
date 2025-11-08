"""# 🧩 Java Annotations — Handy Notes

## 📘 10.11 What is Annotation

### 🔹 Introduction
Annotations in Java are a **powerful metadata feature** introduced in **Java 5**.  
They provide **extra information to the compiler or JVM** about classes, methods, or variables — without directly changing program behavior.

### 🧠 What are Annotations?
- An **annotation** is a **tag/indicator** attached to code elements (class, method, field, etc.).

- Begin with the **`@`** symbol.
- Provide **metadata** processed during **compile-time or runtime**.

---

## ⚙️ Key Characteristics
- Do **not** change program execution directly.  
- Help associate **metadata** with code elements.  
- Can be applied to:
  - Variables  
  - Methods  
  - Constructors  
  - Classes  
- Unlike comments, annotations can be used by the **compiler** or **runtime tools** to modify how the program is processed.

---

## 🏗️ Built-in Java Annotations

Java provides several **predefined annotations**, useful for both **compiler** and **developer** purposes.

### 1️⃣ `@Override`
- Indicates that a method **overrides** a method in its superclass.  
- If it doesn’t override anything → **compile-time error**.  
- Helps prevent method name or parameter mismatches.

```java
class A {
    void show() {
        System.out.println("In A");
    }
}

class B extends A {
    @Override
    void show() {
        System.out.println("In B");
    }
}