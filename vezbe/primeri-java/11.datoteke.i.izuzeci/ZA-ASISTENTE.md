# Недеља 11 — напомене за асистенте

[← Недеља 11](README.md)

## Шта намерно НЕ радимо детаљно

Због ограничења курса не улазимо дубоко у:

- `FileInputStream` и бинарне фајлове;
- серијализацију Java објеката;
- `ObjectInputStream`;
- `RandomAccessFile`;
- целу хијерархију `java.nio`;
- комплексне стратегије retry механизама.

Студент треба да изађе са јасним моделом:

```text
fajl je resurs
čitanje može da ne uspe
greške imaju tip
odgovornost za obradu greške pripada odgovarajućem nivou programa
```
