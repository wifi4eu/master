import { ActionReducer, combineReducers } from '@ngrx/store';
import { compose } from '@ngrx/core';
import { createSelector } from 'reselect';
import { storeFreeze } from 'ngrx-store-freeze';
import { reducers as coreReducers, CoreState, getAppState, localStorageSync } from '@eui/ux-core';

import { environment } from '../../../environments/environment';

// import * as fromTaskManager from '../ux-components/task-manager/index';

/**
 * Define here your app state
 *
 * [IMPORTANT]
 * There are some **reserved** slice of the state
 * that you **can not** use in your application ==> app |user | notification
 */
/* tslint:disable-next-line */
export interface AppState extends CoreState {
    // [key: string]: fromTaskManager.State | any;
}

/**
 * Define here the reduceres of your app
 */
const reducers = Object.assign({}, coreReducers, {
    // [fromTaskManager.namespace]: fromTaskManager.reducers,
});

// --------------------------------------------
// State Selectors
// --------------------------------------------

// --------------------------------------------
// Export reducers (development and production)
// --------------------------------------------

/**
 * Because metareducers take a reducer function and return a new reducer,
 * we can use our compose helper to chain them together.
 * Here we are using combineReducers to make our top level reducer, and then
 * wrapping that in storeFreeze. Remember that compose applies
 * the result from right to left.
 *
 * During development we add the "storeFreeze" middleware to avoid mutation
 * of the state (will throw an error). The will prevent us a lot of headaches :)
 */

const developmentReducer: ActionReducer<AppState> = compose(localStorageSync, storeFreeze, combineReducers)(reducers);
const productionReducer: ActionReducer<AppState> = compose(localStorageSync, combineReducers)(reducers);

export function rootReducer(state: any, action: any) {
    if (environment.production) {
        return productionReducer(state, action);
    }

    return developmentReducer(state, action);
}
