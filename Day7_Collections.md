## Introduction to Collection API
In Java, the term **Collection API** can be confusing because it involves three related terms: **Collection**, **Collections**, and **Collection API**. Although they sound similar, each has a distinct meaning:

- **Collection API**: A set of classes and interfaces used to implement data structures like `ArrayList`, `LinkedList`, `Queue`, etc. It provides a framework for handling groups of objects.
- **Collection**: An interface that serves as the root of the collection hierarchy. It represents a group of objects (elements) and is the parent interface for various data structure classes.
- **Collections**: A utility class containing static methods that operate on collections. It includes algorithms like sorting, searching, and shuffling.

The Collection API was introduced in **Java 1.2** and simplifies working with data.

---

## Why Use the Collection API?

Before the Collection API, developers relied on arrays. Arrays have limitations:

### ❌ Fixed Size
Once declared, array size cannot change. Adding more data requires creating a new array and copying elements.

### ❌ Homogeneous Data
Arrays can store only one data type. Handling multiple fields becomes cumbersome.

### ❌ Complex Operations
Sorting, inserting, or removing require manual implementation.

The Collection API solves these issues using flexible data structures.

---

## Advantages of the Collection API

1. **Dynamic Sizing** – Collections like `ArrayList` grow or shrink automatically.
2. **Supports Heterogeneous Data** – Can store mixed types.
3. **Built-in Methods** – Provides methods for inserting, searching, sorting, deletion.
4. **Efficient Memory Usage** – Auto-adjusts internal capacity.

---

## Key Components of the Collection API

### **List Interface**
Ordered collection allowing duplicates.  
Examples: `ArrayList`, `LinkedList`, `Vector`.

### **Set Interface**
Does not allow duplicates.  
Examples: `HashSet`, `LinkedHashSet`, `TreeSet`.

### **Map Interface**
Stores key-value pairs.  
Examples: `HashMap`, `LinkedHashMap`, `TreeMap`.

### **Queue Interface**
Stores elements prior to processing (FIFO).  
Examples: `PriorityQueue`, `ArrayDeque`.

---

## Comparison with Arrays

| Feature | Arrays | Collection API |
|--------|--------|----------------|
| Size | Fixed | Dynamic |
| Data Type | Homogeneous | Homogeneous / Heterogeneous |
| Built-in Methods | Limited | Extensive |
| Performance (Insertion/Deletion) | Manual coding required | Efficient built-in methods |
| Memory Management | Manual resizing | Automatic resizing |



# 13.2 — ArrayList (Collections Framework)

## 📌 Introduction to Collections

Starting from **Java 1.2**, the *Collections Framework* was introduced to improve array operations and provide a standard set of **interfaces and classes** for handling data.

To use Collections, you must import the **`java.util`** package.

### ✨ Why `java.util`?

* Earlier, core classes were in `java.lang` (auto-imported).
* Collections API lives in `java.util`, also called the *utility package*.
* It provides methods for sorting, searching, and manipulating data.

---

## 📌 Hierarchy of the Collection Interface

The Collection Framework hierarchy:

```
Iterable
   ↓
Collection
   ├── List
   ├── Queue
   └── Set
```

### **List Interface**

Implemented by:

* `ArrayList`
* `LinkedList`
* `Vector`

### **Queue Interface**

Implemented by:

* `PriorityQueue`
* `ArrayDeque` (implements Deque → extends Queue)

### **Set Interface**

Implemented by:

* `HashSet`
* `LinkedHashSet`

### **Map Interface**

(Not part of Collection hierarchy but part of Collections Framework)
Implemented by:

* `HashMap`
* `LinkedHashMap`

---

## 📌 Example: Using Collection & ArrayList

```java
import java.util.Collection;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        // Using Collection interface with ArrayList implementation
        Collection<Integer> nums = new ArrayList<Integer>();

        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(9);
        nums.add(8);
        nums.add(7);

        // Printing the ArrayList
        System.out.println(nums);
    }
}
```

### ✅ Output

```
[3, 4, 5, 9, 8, 7]
```

---

## 📌 Explanation

* The code uses the **Collection interface** with **ArrayList** implementation.
* IDEs may warn you to **use generics** → ensures type safety.
* Collections store elements as **objects**.

  * For primitives, wrapper classes are required (e.g., `Integer` instead of `int`).
* `add()` inserts elements.
* The collection's `toString()` prints all elements automatically.

---

## 📌 Printing Elements Separately (Enhanced For Loop)

```java
for (Integer num : nums) {
    System.out.println(num);
}
```

---

## 📌 Accessing Elements by Index

The **Collection** interface does *not* support indexing.
Use the **List** interface to access elements via index.

```java
List<Integer> numList = new ArrayList<>(nums);
System.out.println("Element at index 2: " + numList.get(2));
```

### Sample Output:

```
Element at index 2: 5
```

---

## 📌 Additional Useful ArrayList Methods

Here are more helpful methods (not in PDF but essential):

```java
List<String> names = new ArrayList<>();

names.add("Ram");
names.add("Shyam");
names.add("Mohan");

names.remove(1);   // remove by index
names.contains("Ram");
names.size();
names.clear();
```

---

## 🎯 Summary

* Collections API offers flexible, powerful data-handling tools.
* `ArrayList` is the most commonly used List implementation.
* Use `Collection` for general operations.
* Use `List` when indexing is required.


# 13.x — Set (Collections Framework)

## 📌 Introduction to Set in Java Collections
The **Set** interface is a part of the Java Collections Framework and represents a **collection of unique elements**. Unlike `List`, a `Set` does **not allow duplicates** and may or may not maintain insertion order depending on the implementation.

All Set implementations are found in the **`java.util`** package.

---

## 📌 Why Use a Set?
Use a Set when:
- You need **unique values**
- You do **not** require index-based access
- You want fast **search**, **insert**, and **delete** operations

---

## 📌 Hierarchy of Set Interface
```
Collection
   └── Set
         ├── HashSet
         ├── LinkedHashSet
         └── SortedSet
               └── TreeSet
```

### **HashSet**
- No duplicates
- No guaranteed order (random order)
- Uses hashing → fast performance

### **LinkedHashSet**
- No duplicates
- **Maintains insertion order**

### **TreeSet**
- No duplicates
- **Sorted** in ascending order
- Uses Red-Black Tree (slower than HashSet)

---

## 📌 Example: Basic HashSet Usage
```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();

        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(20); // duplicate ignored

        System.out.println(nums);
    }
}
```
### ✅ Output (Order not guaranteed)
```
[20, 10, 30]
```

---

## 📌 Why Duplicates Are Not Allowed?
Set uses internal **hashing**, which ensures that:
- Equal values have the same hash
- Duplicate elements are not inserted

---

## 📌 Example: LinkedHashSet (Maintains Insertion Order)
```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> names = new LinkedHashSet<>();

        names.add("Virat");
        names.add("Rohit");
        names.add("Bumrah");
        names.add("Rohit"); // duplicate ignored

        System.out.println(names);
    }
}
```
### ✅ Output
```
[Virat, Rohit, Bumrah]
```

---

## 📌 Example: TreeSet (Sorted Set)
```java
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> nums = new TreeSet<>();

        nums.add(50);
        nums.add(10);
        nums.add(30);
        nums.add(20);

        System.out.println(nums);
    }
}
```
### ✅ Output (Sorted Order)
```
[10, 20, 30, 50]
```

---

## 📌 Iterating Through a Set
Set does not support indexing, so use:
- Enhanced for-loop
- Iterator

### Example:
```java
for (Integer n : nums) {
    System.out.println(n);
}
```

---

## 📌 Useful Methods in Set
```java
Set<String> items = new HashSet<>();

items.add("Apple");
items.add("Banana");
items.add("Orange");

items.contains("Banana");  // true
items.remove("Orange");    // removes element
items.size();               // returns number of elements
items.clear();              // removes all elements
```

---

## 📌 Differences Between HashSet, LinkedHashSet & TreeSet
| Feature | HashSet | LinkedHashSet | TreeSet |
|---------|---------|----------------|----------|
| Order | No | Yes (insertion order) | Yes (sorted) |
| Speed | Fastest | Slightly slower | Slowest |
| Allows null? | Yes | Yes | No |
| Duplicate allowed | No | No | No |

---

## 📌 When to Use Which Set?
- **HashSet** → Best for fast operations (search, add, delete)
- **LinkedHashSet** → When order must be preserved
- **TreeSet** → When automatic sorting is required

---

## 🎯 Summary
- `Set` stores **unique** values
- `HashSet` → Fastest, no order
- `LinkedHashSet` → Maintains insertion order
- `TreeSet` → Automatically sorted
- Set does not support indexing

A Set is ideal when **uniqueness** is the requirement.

# 13.x — Map in Collections Framework

## 📌 Introduction to Map Interface
The **Map** interface is a part of the Java Collections Framework but **not a sub-interface of Collection**. It stores data in the form of **key–value pairs**.

### ✔ Key Features of Map:
- Stores elements as **key → value**.
- **Keys are unique**, but values may be duplicate.
- Allows fast lookup using keys.
- Useful when you need to map one value to another (e.g., ID → Name).

### Common Implementations:
- **HashMap** → Fastest, no order guaranteed.
- **LinkedHashMap** → Maintains insertion order.
- **TreeMap** → Stores keys in sorted order.

---

## 📌 Map Interface Hierarchy
```
Map
 ├── HashMap
 │     └── LinkedHashMap
 └── SortedMap
        └── TreeMap
```
> Note: `Map` does not extend `Collection` but is part of the Collections Framework.

---

## 📌 Basic Example: Using HashMap
```java
import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(1, "Rohit");
        students.put(2, "Virat");
        students.put(3, "Surya");

        System.out.println(students);
    }
}
```
### ✅ Output
```
{1=Rohit, 2=Virat, 3=Surya}
```

---

## 📌 Accessing Elements in Map
### ✔ Get value using key
```java
System.out.println(students.get(2));   // Virat
```

### ✔ Check if a key or value exists
```java
students.containsKey(3);
students.containsValue("Rohit");
```

### ✔ Remove a key-value pair
```java
students.remove(1);
```

---

## 📌 Iterating Over Map Entries
Since Map does not support indexing, we use **entrySet()**, **keySet()**, or **values()**.

### ✔ 1. Iterating using entrySet()
```java
for (Map.Entry<Integer, String> entry : students.entrySet()) {
    System.out.println(entry.getKey() + " → " + entry.getValue());
}
```

### ✔ 2. Iterating over keys
```java
for (Integer key : students.keySet()) {
    System.out.println(key);
}
```

### ✔ 3. Iterating over values
```java
for (String value : students.values()) {
    System.out.println(value);
}
```

---

## 📌 HashMap vs LinkedHashMap vs TreeMap

| Feature | HashMap | LinkedHashMap | TreeMap |
|--------|---------|----------------|---------|
| Order | No order | Maintains insertion order | Sorted by keys |
| Speed | Fastest | Slightly slower | Slower (due to sorting) |
| Allows null keys? | Yes | Yes | No |

---

## 📌 Example: LinkedHashMap (Maintains Order)
```java
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> marks = new LinkedHashMap<>();

        marks.put("English", 90);
        marks.put("Math", 95);
        marks.put("Science", 85);

        System.out.println(marks);
    }
}
```
### Output:
```
{English=90, Math=95, Science=85}
```

---

## 📌 Example: TreeMap (Sorted Keys)
```java
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> items = new TreeMap<>();

        items.put(30, "Keyboard");
        items.put(10, "Mouse");
        items.put(20, "Monitor");

        System.out.println(items); // Sorted by key
    }
}
```
### Output:
```
{10=Mouse, 20=Monitor, 30=Keyboard}
```

---

## 📌 Additional Useful Map Methods
```java
map.size();
map.isEmpty();
map.clear();
map.replace(key, newValue);
map.putIfAbsent(key, value);
```

---

## 🎯 Summary
- `Map` stores data as **key-value pairs**.
- Keys must be unique; values can repeat.
- `HashMap` → Best performance.
- `LinkedHashMap` → Preserves insertion order.
- `TreeMap` → Automatically sorts keys.
- Provides efficient lookup and is widely used in real-world applications.

# 13.5 — Comparable & Comparator in Collections Framework

## 📌 Introduction
When working with Collections like `ArrayList`, `TreeSet`, or `TreeMap`, we often need to **sort custom objects**. Java provides two key interfaces to define sorting logic:

- **Comparable** — Natural ordering (default sorting)
- **Comparator** — Custom ordering (multiple sorting strategies)

Both are part of the **java.util** and **java.lang** packages.

---

## 📌 Why Do We Need Comparable & Comparator?
Collections like `Collections.sort()` and sorted data structures (e.g., `TreeSet`, `TreeMap`) need to know **how to compare objects**.

Primitive types have built-in comparison, but **custom objects do not**.

Example: Sorting a list of `Student` objects by marks, name, or age.

---

# ✅ Comparable Interface
Location: **`java.lang.Comparable`**

Used to define **default sorting** (natural order) for a class.

### 📌 Method
```java
public int compareTo(T o);
```
Returns:
- `0` → equal
- positive → current object is greater
- negative → current object is smaller

---

## 📌 Example: Using Comparable
Sorting students by **ID (natural order)**.

```java
class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.id - s.id;  // natural sorting by ID
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
```

### 📌 Main Class
```java
import java.util.*;

public class DemoComparable {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Rahul"));
        list.add(new Student(1, "Aman"));
        list.add(new Student(2, "Sneha"));

        Collections.sort(list);  // Uses compareTo

        System.out.println(list);
    }
}
```

### ✅ Output
```
[1 - Aman, 2 - Sneha, 3 - Rahul]
```

---

# ✅ Comparator Interface
Location: **`java.util.Comparator`**

Used to define **custom sorting**.
You can create **multiple comparators** for the same class.

### 📌 Method
```java
public int compare(T o1, T o2);
```

---

## 📌 Example: Using Comparator
Sorting students by **name**.

```java
import java.util.Comparator;

class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}
```

Sorting by **id (descending)**.
```java
class SortByIdDesc implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.id - s1.id;  // descending
    }
}
```

### 📌 Main Class
```java
import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Rahul"));
        list.add(new Student(1, "Aman"));
        list.add(new Student(2, "Sneha"));

        Collections.sort(list, new SortByName());
        System.out.println("Sorted by Name: " + list);

        Collections.sort(list, new SortByIdDesc());
        System.out.println("Sorted by ID Desc: " + list);
    }
}
```

### ✅ Output
```
Sorted by Name: [1 - Aman, 3 - Rahul, 2 - Sneha]
Sorted by ID Desc: [3 - Rahul, 2 - Sneha, 1 - Aman]
```

---

# 📌 Comparable vs Comparator — Comparison Table
| Feature | Comparable | Comparator |
|--------|------------|------------|
| Package | java.lang | java.util |
| Method | compareTo() | compare() |
| Modifies | Same class | Separate class |
| Number of sort orders | Only one | Multiple possible |
| Use Case | Natural sorting | Custom sorting |

---

# 📌 Real-Life Analogy
### 📘 Comparable → Student's Roll Number
- Every student has **one natural ordering** (roll number)

### 📘 Comparator → Sort by Marks, Name, Age
- Multiple different sorting rules

---

# 🎯 Summary
- `Comparable` → Use when class has **natural sorting**.
- `Comparator` → Use when **multiple sorting rules** are needed.
- Both return an `int` which decides the order.
- Used extensively in Collections like `ArrayList`, `TreeSet`, and `TreeMap`.

If you want, I can create interview questions, MCQs, diagrams, or add this to your existing combined Collections Notes file.

