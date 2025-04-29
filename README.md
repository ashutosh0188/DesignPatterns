# Design Patterns Overview 🚀

## 📌 Introduction
Design patterns are best practices for solving common software design challenges. They are classified into three categories:

1. **Creational Patterns** - Focus on object creation mechanisms.
2. **Structural Patterns** - Deal with composition and relationships.
3. **Behavioral Patterns** - Define communication between objects.

---

## 🏗️ Creational Design Patterns
Creational patterns manage **how objects are created** to increase flexibility and reuse.

| Pattern          | Description | Example |
|-----------------|-------------|---------|
| **Factory** | Creates objects without exposing instantiation logic | Payment gateway selecting UPI vs Credit Card |
| **Abstract Factory** | Produces families of related objects | Creating payment processors & validators together |
| **Builder** | Helps create complex objects step-by-step | Configuring a loan application with custom options |
| **Singleton** | Ensures a single instance of a class | Database connection pool in an application |

---

## 🏛️ Structural Design Patterns
Structural patterns **define how objects are composed** and connected.

| Pattern          | Description | Example |
|-----------------|-------------|---------|
| **Adapter** | Converts one interface into another | Phone charger adapter for different sockets |
| **Bridge** | Separates abstraction from implementation | Streaming platform (YouTube, Netflix) working on TV & mobile |
| **Composite** | Treats individual and grouped objects the same way | Product categories in an e-commerce platform |
| **Decorator** | Dynamically adds functionality to objects | Customizing coffee orders with add-ons |
| **Facade** | Provides a simplified interface for a complex system | Payment gateway handling multiple services behind a single API |
| **Proxy** | Controls access to objects | VPN acting as an intermediary for internet requests |

---

## ⚡ Behavioral Design Patterns
Behavioral patterns **define object interactions and responsibility distribution**.

| Pattern          | Description | Example |
|-----------------|-------------|---------|
| **Chain of Responsibility** | Passes requests along a chain | Customer support (agent → manager → director) |
| **Command** | Encapsulates a request as an object | Remote control executing TV commands |
| **Observer** | Notifies dependent objects automatically | Social media notifications for new posts |
| **Strategy** | Selects an algorithm dynamically | Google Maps choosing best route based on traffic |
| **State** | Changes object behavior based on state | ATM behaving differently when out of cash |
| **Template Method** | Defines steps for an algorithm with variations | Cooking different types of pasta |

---

## 🎯 How to Use This Repository
- Read the explanations for each pattern to understand their core concepts.
- Check example code implementations in Java.
- Experiment with modifying patterns to fit your projects.

---

## 🔗 Resources
- [Design Patterns - Gang of Four](https://refactoring.guru/design-patterns)

---

## ✨ Contributing
Feel free to suggest improvements, add more examples, or report issues!

---

## 📜 License
This project is licensed under the MIT License.
