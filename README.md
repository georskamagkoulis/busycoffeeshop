# busycoffeeshop

A small coffee shop simulation written in Java 17 with Maven. A customer places orders in the console, two employees prepare them at the same time on separate threads, and at the end the program prints a receipt and a shift report.

I built it step by step while learning Java, to practice records, enums, sealed types, threads and collections in one small, runnable project.

## Features

- Interactive console menu: choose a coffee, quantity (1-20), milk (y/n) and sugar level
- Two employees (John and Jane) prepare orders concurrently from a shared order board
- Receipt with a 10% discount on lines of more than 10 cups
- Shift report: orders and working time per employee, total orders and best seller
- Unit tests with JUnit 5

## Requirements

- Java 17 or newer
- Maven 3.8+

## Build and run

```bash
mvn clean package
java -jar target/busycoffeeshop-1.0-SNAPSHOT.jar
```

## Run the tests

```bash
mvn test
```

## Example session (shortened)

```text
Menu:
1. Freddo Espresso - 2.30 EUR
2. Freddo Cappuccino - 3.80 EUR
3. Frappe - 2.50 EUR
4. Latte - 3.30 EUR
0. Done - start preparing
Choose: 1
Quantity (1-20): 2
With milk? (y/n): n
Sugar (0=NONE, 1=LOW, 2=MEDIUM, 3=HIGH): 1
Added: Freddo Espresso x2
...
Choose: 0

Jane starts Latte (order 1)
John starts Freddo Espresso (order 0)
John finished Freddo Espresso (order 0)
John: no more orders, going home
Jane finished Latte (order 1)
Jane: no more orders, going home
============ RECEIPT ============
#0 Freddo Espresso     2 x  2.30 =    4.60
#1 Latte               3 x  3.30 =    9.90
---------------------------------
TOTAL: 14.50 EUR
========== SHIFT REPORT ==========
Jane   : 1 orders, 4 s of work
John   : 1 orders, 3 s of work
----------------------------------
Total orders : 2
Best seller  : Latte (3)
Shop closed
```

The order in which the employees start and finish can differ from run to run, because they work on separate threads.

## Project structure

```text
src/main/java/gr/skam/busycoffeeshop/
├── CoffeeShopMain.java     entry point: reads orders, starts the employees, prints the results
├── ConsoleInput.java       reads and validates the user's orders (AutoCloseable)
├── Order.java              record with an AtomicInteger id counter and the menu printer
├── Product.java            sealed interface (only Coffee is permitted)
├── Coffee.java             record implementing Product, with validation
├── CoffeeType.java         enum with display name and price, plus lookup by name
├── SugarLevel.java         enum: NONE, LOW, MEDIUM, HIGH
├── Employee.java           record that takes orders from the board and prepares them
├── OrderBoard.java         shared queue of orders, protected with synchronized
├── Receipt.java            utility class that computes totals and prints the receipt
├── ShiftReport.java        per-employee and per-product statistics in ConcurrentHashMaps
└── InvalidProductNameException.java

src/test/java/gr/skam/busycoffeeshop/
└── ReceiptTest.java        (and other tests)
```

## Java concepts used

| Concept | Where |
|---|---|
| `record` (compact constructor, implementing an interface) | `Order`, `Coffee`, `Employee` |
| `enum` with fields and methods | `CoffeeType`, `SugarLevel` |
| `sealed` interface with `permits` | `Product` |
| `var` | throughout |
| Threads (`start`, `join`, `sleep`) | `CoffeeShopMain`, `Employee` |
| `synchronized` (shared order board) | `OrderBoard` |
| `AtomicInteger` (thread-safe id counter) | `Order` |
| `ConcurrentHashMap` and `merge` | `ShiftReport` |
| `TreeMap` for sorted output | `ShiftReport` |
| Lambdas and method references | `CoffeeShopMain`, `ShiftReport` |
| try-with-resources / `AutoCloseable` | `ConsoleInput` |
| Custom exception | `InvalidProductNameException` |
| JUnit 5 unit tests | `src/test/java` |

## Known limitations and ideas

- Orders are entered before the employees start; live ordering would need a `BlockingQueue`
- Money is stored as `double`; `BigDecimal` would be more correct
- Ingredient stock (inventory) is not tracked yet
- Reports are only printed, not saved to a file

## Roadmap

- [x] Console ordering and concurrent employees
- [x] Receipt and shift report
- [x] Unit tests (JUnit 5)
- [ ] Inventory with a synchronized stock check
- [ ] Live orders with `BlockingQueue`
- [ ] Save reports to a file
- [ ] GitHub Actions to run the tests on every push

## Author

Georgios Skamagkoulis, student of Management Science and Technology at the Athens University of Economics and Business.
