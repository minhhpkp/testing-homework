# Week 4 homework

Consider a function from a hypothetical e-commerce website:

## Specification

**Function:** CalculateTotalPrice

**Description:** This function calculates the total price of items in a shopping cart, including taxes and discounts.

**Parameters:**

- Cart (list of tuples): Each tuple contains the following information for an item: (item_name, quantity, unit_price).
- TaxRate (float): The tax rate to be applied to the total price.
- DiscountAmount (float): The discount amount to be subtracted from the total price.

**Rules:**

1. The Items list must not be empty.
2. Quantity for each item must be greater than zero.
3. Unit price for each item must be greater than zero.
4. Tax rate must be a non-negative value.
5. Discount amount must be a non-negative value.
6. Return value of total price should be rounded to the second decimal place.

Let's apply Boundary Value Analysis and Decision Tables to test this function:

## Boundary Value Analysis

### Test values for Cart

- Norm value: Choose a list with at least two items, e.g. a cart with the following 2 items:

| Name   | Quantity | Unit Price |
| ------ | -------- | ---------- |
| item 1 | 5        | 35.25      |
| item 2 | 12       | 49.99      |

- Boundary values: Choose an empty list and a list with only one item.

### Test values for Quantity

- Norm value: Choose a quantity greater than zero.

- Boundary values: -1, 0 and 1.

### Test values for Unit Price

- Norm value: Choose a unit price greater than zero.

- Boundary values: -0.01, 0 and 0.01.

### Test values for Tax Rate

- Norm value: Choose a tax rate in the range of 0 to 100 percent, e.g. 50 percent.

- Boundary values: -0.1, 0, 0.1, 99.9, 100 and 100.1.

### Test values for Discount Amount

- Norm value: Choose a non-negative discount amount e.g. 5.45.

- Boundary values: -0.01, 0 and 0.01.

## Decision Tables

| Conditions/Cases:                                                 | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| ----------------------------------------------------------------- | --- | --- | --- | --- | --- | --- | --- |
| Empty cart                                                        | Y   | N   | N   | N   | N   | N   | N   |
| Cart contains at least one item                                   | N   | Y   | Y   | Y   | Y   | Y   | Y   |
| There exists an item with non-positive quantity                   | —   | Y   | N   | N   | N   | N   | N   |
| Every quantity is positive                                        | —   | N   | Y   | Y   | Y   | Y   | Y   |
| There exists an item with non-positive unit price                 | —   | —   | Y   | N   | N   | N   | N   |
| Every unit price is positive                                      | —   | —   | N   | Y   | Y   | Y   | Y   |
| The tax rate is negative                                          | —   | —   | —   | Y   | N   | N   | N   |
| The tax rate is in the range of 0 to 100 (both inclusive) percent | —   | —   | —   | N   | Y   | N   | N   |
| The tax rate is greater than 100 percent                          | —   | —   | —   | N   | N   | Y   | Y   |
| The discount amount is negative                                   | —   | —   | —   | —   | —   | Y   | N   |
| The discount amount is non-negative                               | —   | —   | —   | —   | —   | N   | Y   |
| **Actions:**                                                      |     |     |     |     |     |     |     |
| Calculate total price                                             |     |     |     |     |     |     | 1   |
| Do not calculate total price                                      | 1   | 1   | 1   | 1   | 1   | 1   |     |

## Test cases and test result

| Test case # | Input                                                                 |         |          | Expected output          | Actual output            | Verdict |
| ----------- | --------------------------------------------------------------------- | ------- | -------- | ------------------------ | ------------------------ | ------- |
|             | cart                                                                  | taxRate | discount |                          |                          |         |
| 1           | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 50      | 5.45     | 1158.75                  | 1158.745                 | Failed  |
| 2           | {}                                                                    | 50      | 5.45     | IllegalArgumentException | IllegalArgumentException | Passed  |
| 3           | { ("item 1", 50, 25.99) }                                             | 50      | 5.45     | 1943.8                   | 1943.8                   | Passed  |
| 4           | { ("item 1", 5, 35.25), ("item 2", -10, 49.99) }                      | 50      | 5.45     | IllegalArgumentException | Nothing was thrown       | Failed  |
| 5           | { ("item 1", 0, 35.25), ("item 2", 12, 49.99) }                       | 50      | 5.45     | IllegalArgumentException | Nothing was thrown       | Failed  |
| 6           | { ("item 1", 5, 35.25), ("item 2", 12, 49.99), ("item 3", 1, 49.99) } | 50      | 5.45     | 1233.73                  | 1233.73                  | Passed  |
| 7           | { ("item 1", 5, 35.25), ("item 2", 12, -0.01) }                       | 50      | 5.45     | IllegalArgumentException | Nothing was thrown       | Failed  |
| 8           | { ("item 1", 5, 0.0), ("item 2", 12, 49.99) }                         | 50      | 5.45     | IllegalArgumentException | Nothing was thrown       | Failed  |
| 9           | { ("item 1", 5, 35.25), ("item 2", 12, 0.01) }                        | 50      | 5.45     | 259.11                   | 259.105                  | Failed  |
| 10          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | -0.1    | 5.45     | IllegalArgumentException | Nothing was thrown       | Failed  |
| 11          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 0       | 5.45     | 770.68                   | 770.68                   | Passed  |
| 12          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 0.1     | 5.45     | 771.46                   | 771.4561299999999        | Failed  |
| 13          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 99.9    | 5.45     | 1546.03                  | 1546.03387               | Failed  |
| 14          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 100.0   | 5.45     | 1546.81                  | 1546.81                  | Passed  |
| 15          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 100.1   | 5.45     | IllegalArgumentException | Nothing was thrown       | Failed  |
| 16          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 50      | -0.01    | IllegalArgumentException | Nothing was thrown       | Failed  |
| 17          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 50      | 0        | 1164.2                   | 1164.195                 | Failed  |
| 18          | { ("item 1", 5, 35.25), ("item 2", 12, 49.99) }                       | 50      | 0.01     | 1164.19                  | 1164.185                 | Failed  |

Total passed: 5/18
