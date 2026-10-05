# Nedelja 11 — napomene za asistente

[← Nedelja 11](README.md)

## Šta namerno NE radimo detaljno

Zbog ograničenja kursa ne ulazimo duboko u:

- `FileInputStream` i binarne fajlove;
- serijalizaciju Java objekata;
- `ObjectInputStream`;
- `RandomAccessFile`;
- celu hijerarhiju `java.nio`;
- kompleksne strategije retry mehanizama.

Student treba da izađe sa jasnim modelom:

```text
fajl je resurs
čitanje može da ne uspe
greške imaju tip
odgovornost za obradu greške pripada odgovarajućem nivou programa
```
