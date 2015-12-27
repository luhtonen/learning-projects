import makeStore from './src/store';
import startSever from './src/server';

export const store = makeStore();
startSever(store);
