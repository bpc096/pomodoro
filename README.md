

#### DOCUMENTATION
+ memperbaiki bug posisi state yang salah
+ memperbaiki bug skip pada BreakUI & LongBreak (sebelumnya kalau di skip jadi kedouble)
+ menambahkan status state pada BreakUI (ada state hitamnya)
+ state sudah bisa jalan dengan lancar (sampai ke long break) -> front end sudah jadi
+ menghilangkan state pada long break
+ sudah bisa nambah stats pada hari ini di statistic (tapi masih error) karena harus ada file yang harus dibaca.
- kodingan masih barbar, tapi program sudah jadi. Harus diperbaiki
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
