import makeStore from './src/store';
import startSever from './src/server';

export const store = makeStore();
startSever(store);

store.dispatch({
    type: 'SET_ENTRIES',
    entries: require('./entries.json')
});
store.dispatch({type: 'NEXT'});
