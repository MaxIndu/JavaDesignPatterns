# Vector vs ArrayList in Java

ArrayList and Vectors both implement the List interface and both use **(dynamically resizable) arrays** for its internal data structure, much like using an ordinary array.

* **Synchronization :**  Vector is **synchronized**, which means only one thread at a time can access the code, while arrayList is **not synchronized**
* **Performance:** **ArrayList is faster**, since it is non-synchronized, 
  while vector operations give slower performance since they are 
  synchronized (thread-safe). If one thread works on a vector, it has 
  acquired a lock on it, which forces any other thread wanting to work on 
  it to have to wait until the lock is released.
* **Data Growth:**  ArrayList and Vector **both grow and shrink dynamically** to
  maintain optimal use of storage – but the way they resize is different.
  ArrayList increments 50% of the current array size if the number of 
  elements exceeds its capacity, while vector increments 100% – 
  essentially doubling the current array size.
*  **Traversal:**  Vector can use both **Enumeration and Iterator** for traversing over elements of vector while ArrayList can only use **Iterator** for traversing.

```java

// Java Program to illustrate use of ArrayList 
// and Vector in Java 
import java.io.*; 
import java.util.*; 
  
class GFG 
{ 
    public static void main (String[] args) 
    { 
        // creating an ArrayList 
        ArrayList<String> al = new ArrayList<String>(); 
  
        // adding object to arraylist 
        al.add("Practice.GeeksforGeeks.org"); 
        al.add("quiz.GeeksforGeeks.org"); 
        al.add("code.GeeksforGeeks.org"); 
        al.add("contribute.GeeksforGeeks.org"); 
  
        // traversing elements using Iterator' 
        System.out.println("ArrayList elements are:"); 
        Iterator it = al.iterator(); 
        while (it.hasNext()) 
            System.out.println(it.next()); 
  
        // creating Vector 
        Vector<String> v = new Vector<String>(); 
        v.addElement("Practice"); 
        v.addElement("quiz"); 
        v.addElement("code"); 
  
        // traversing elements using Enumeration 
        System.out.println("\nVector elements are:"); 
        Enumeration e = v.elements(); 
        while (e.hasMoreElements()) 
            System.out.println(e.nextElement()); 
    } 
} 

```

```
ArrayList elements are:
Practice.GeeksforGeeks.org
quiz.GeeksforGeeks.org
code.GeeksforGeeks.org
contribute.GeeksforGeeks.org

Vector elements are:
Practice
quiz
code
```

**How to choose between ArrayList and Vector?**

- ArrayList is unsynchronized and not thread-safe, whereas Vectors  are. Only one thread can call methods on a Vector at a time, which is a  slight overhead, but helpful when safety is a concern. Therefore, in a  single-threaded case, arrayList is the obvious choice, but where  multithreading is concerned, vectors are often preferable.
- If we don’t know how much data we are going to have, but know the  rate at which it grows, Vector has an advantage, since we can set the  increment value in vectors.
- ArrayList is newer and faster. If we don’t have any explicit  requirements for using either of them, we use ArrayList over vector.



**References**

https://www.geeksforgeeks.org/java-util-vector-class-java/

