import alt from '../alt';

class FooterActions {
  construstor() {
    this.generateActions(
      'getTopCharactersSuccess',
      'getTopCharactersFail'
    );
  }

  getTopCharacters() {
    $.ajax({ url: '/api/characters/top'})
      .done((data) => {
        this.actions.getTopCharactersSuccess(data);
      })
      .fail((jqXhr) => {
        this.actions.getTopcharactersFail(jqXhr);
      });
  }
}

export default alt.createActions(FooterActions);
