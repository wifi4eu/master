import { ResponseErrorHandlerTypes } from '@eui/ux-core';

export const ROUTE_HANDLERS = {
    routesHandlers: [
        {
            match: '*',
            '404': ResponseErrorHandlerTypes.Notify, // show a growl error message
            '401': ResponseErrorHandlerTypes.Notify, // show a growl error message
            '500': ResponseErrorHandlerTypes.Notify,  // show a growl error message
        }
    ]
};
