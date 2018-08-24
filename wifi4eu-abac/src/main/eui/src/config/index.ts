import { GLOBAL } from './global';
import { MODULES } from './modules';
import { ROUTE_HANDLERS } from './routeHandlers';

export const appConfig = {
    global: GLOBAL,
    httpResponseHandlers: ROUTE_HANDLERS,
    modules: MODULES
};
