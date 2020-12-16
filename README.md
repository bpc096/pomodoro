# Pomodoro - Java
Tugas Project Pomodoro untuk matakuliah Framework Layer Architecture

## Run the Java Program

#### Prepare the Project :
On your local machine, clone this repo:

```
git clone https://github.com/bpc096/pomodoro.git
cd pomodoro
```

Please Use Eclipse IDE for better performance, you can use some Java IDE to run this project.
Coding yourself and enjoyed!

# To change time speed and time duration


To change time speed, go to
#### resume()

change the variable (number 10), and choose from 10 (sonic the hedgehog fast), 100 (okay fast), 1000 (normal time)

```
workTimer = new Timer(10, new ActionListener()
```

To change time duration, change it in declaration in global scope

```
#WorkUI.java
int workSecond = 0;
int workMinute = 3;
```

don't forget to change the first format (also in global scope)

```
JLabel lblWorkTime = new JLabel("03:00");
```
