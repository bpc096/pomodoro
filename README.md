# Pomodoro - Java
Tugas Project Pomodoro untuk matakuliah Framework Layer Architecture

## Run the Java Program

#### Prepare the Project :
On your local machine, clone this repo:

```
git clone https://github.com/bpc096/pomodoro
cd pomodoro
```

Please Use Eclipse IDE for better performance, you can use some Java IDE to run this project.

#### Coding yourself and enjoyed!

#### DOCUMENTATION
front end sudah dibenerin / jadi:
+ memperbaiki bug posisi state yang salah
+ memperbaiki bug skip pada BreakUI & LongBreak (sebelumnya kalau di skip jadi kedouble)
+ menambahkan status state pada BreakUI (ada state hitamnya)
+ menghilangkan state pada long break karena tidak diperlukan

backend sudah jadi, tetapi masih ada bug:
+ state sudah bisa jalan dengan lancar (sampai ke long break)
+ kalau program sudah dijalankan dan sampai akhir longbreak, nanti statistik sudah bisa nambah angka 1 sesuai hari pomodoro dijalankan
- walaupun sudah jadi, statistik masih tidak bisa tersimpan, alias kalau pomodoro dijalankan lagi akan tereset
- kodingan masih barbar, tapi program sudah jadi. Harus dirapihin (banyak class tidak terpakai)

# To change time speed and time duration


To change time speed, go to
#### resume()

change the variable (number 10), and choose from 10 (sonic the hedgehog fast), 100 (okay fast), 1000 (normal time)

```
workTimer = new Timer(10, new ActionListener()
```

To change time duration, change it in declaration in global scope

```
int workSecond = 0;
int workMinute = 3;
```

don't forget to change the first format (also in global scope)

```
JLabel lblWorkTime = new JLabel("03:00");
```
