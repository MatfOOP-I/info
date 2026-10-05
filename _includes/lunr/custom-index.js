// Подразумевани lunr trimmer користи \W, па би из ћириличних речи уклонио сва слова.
// Мењамо га верзијом која препознаје Unicode слова и цифре (једном, пре првог документа).
if (!this.__unicodeTrimmer) {
  var unicodeTrimmer = function (token) {
    return token.update(function (s) {
      return s.replace(/^[^\p{L}\p{N}]+/u, '').replace(/[^\p{L}\p{N}]+$/u, '');
    });
  };
  lunr.Pipeline.registerFunction(unicodeTrimmer, 'unicodeTrimmer');
  this.pipeline.after(lunr.trimmer, unicodeTrimmer);
  this.pipeline.remove(lunr.trimmer);
  this.__unicodeTrimmer = true;
}
