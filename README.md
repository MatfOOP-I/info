# Објектно-оријентисано програмирање (И смер) @ МАТФ

Материјали за курс **Објектно-оријентисано програмирање** на **И смеру** основних студија Математичког факултета Универзитета у Београду.

**Сајт курса: <https://matfoop-i.github.io/info/>**

## Садржај

* [Информације о курсу](informacije/README.md) — наставници, начин реализације, бодовање и литература
* [Инсталације](INSTALACIJE.md) и [ресурси за учење](RESURSI-ZA-UCENJE.md)
* [Предавања](predavanja/README.md)
* [Вежбе](vezbe/README.md) — 13 недеља примера и задатака
* Испити: [писмени](pismeni-ispiti/README.md) и [усмени](usmeni-ispiti/README.md)
* [Архива](arhiva.md) — материјали из претходних школских година

## Уређивање сајта

Сајт се гради помоћу [GitHub Pages](https://pages.github.com/) и теме [Just the Docs](https://just-the-docs.com/).

* Почетна страница сајта (са новостима) је [`index.md`](index.md).
* Наслови, редослед и хијерархија странице у менију подешавају се у [`_config.yml`](_config.yml) (одељак `defaults`).
* Локални преглед (потребан Docker), па отворити <http://localhost:4000/info/>:

  ```
  docker run --rm -it -p 4000:4000 -v "${PWD}:/site" -v oop-gems:/usr/local/bundle -w /site ruby:3.3 bash -c "bundle install && bundle exec jekyll serve --host 0.0.0.0 --no-watch"
  ```

## Лиценца

Садржај је заштићен лиценцом [Creative Commons Attribution-NonCommercial 3.0](https://creativecommons.org/licenses/by-nc/3.0/), а програмски код [MIT лиценцом](LICENSE).
