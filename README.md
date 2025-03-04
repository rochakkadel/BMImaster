# BMI Calculator Project - Java

## Overview

This is a simple BMI (Body Mass Index) calculator implemented in Java. The program allows users to input their height and weight in either English or Metric units. It then calculates and provides a report of their BMI and weight status (Underweight, Healthy Weight, Overweight, or Obesity). Additionally, the program includes a table to display the BMI values for a range of weights.

## Features

- **Multiple versions:** 
  - English (Pounds and Feet/Inches)
  - Metric (Kilograms and Centimeters)
  
- **Interactive user input:**
  - Users can input their name, height, and weight.
  
- **Summary Report:**
  - Displays the calculated BMI, weight status, and the current date and time.
  
- **Weight Status Classification:**
  - Underweight: BMI < 18.5
  - Healthy Weight: 18.5 ≤ BMI ≤ 24.9
  - Overweight: 25 ≤ BMI ≤ 29.9
  - Obesity: BMI ≥ 30
  
- **Weight Range Table:**
  - Displays BMI values for a range of weights (from low to high) with corresponding weight statuses.

- **Exit option:** Users can type `!` to exit the program at any time.

## Getting Started

### Prerequisites

- Java 8 or higher is required to run the program.

### How to Run

1. **Clone the repository** or **download the code**.
2. Open the project in your preferred IDE or a text editor.
3. Compile the Java file (`BMI_Master_RochakKadel.java`).
4. Run the program in your terminal or IDE.

### Sample Output

```bash
My BMI Calculator Projects:
  1. BMI, English
  2. BMI, Metric

[ USER MANUAL ] Enter an exclamation mark ! to end.
Please enter the version you want to try: e

-------------------------------------------------------------------------
-- Wellcome to:
--               BODY MASS INDEX (BMI) Computation, Rochak Kadel English Version
-------------------------------------------------------------------------

Please enter your full name: John Doe
Please enter height in feet and inches for John Doe: 5 10
Please enter weight in pounds for John Doe: 180

-- SUMMARY REPORT for JOHN DOE
-- Date and Time:              03/03/2025 02:45 PM 
-- BMI:                      25.8 (or 26 if rounded) 
-- Weight Status:              Overweight

-------------------------------------------------------------
Weight    | BMI      | WEIGHT                                    
-------------------------------------------------------------
130.00    | 19.7     | Underweight (LOW)                          
135.50    | 20.9     | Healthy Weight                            
...       | ...      | ...
180.00    | 25.8     | Overweight (this)
...
220.00    | 31.5     | Obesity (HIGH)
-------------------------------------------------------------

```

## How It Works

### English Version

- Users input their height in feet and inches, and weight in pounds.
- BMI is calculated and displayed along with weight status.
- The program also displays a table showing BMI for weights from low to high.
  
### Metric Version

- Users input their height in centimeters, and weight in kilograms.
- BMI is calculated similarly as in the English version, but using metric units.
- A similar weight range table is displayed.

## Contributing

If you'd like to contribute to the project, feel free to open a pull request or submit an issue.

## License

This project is open-source and available under the MIT License.

