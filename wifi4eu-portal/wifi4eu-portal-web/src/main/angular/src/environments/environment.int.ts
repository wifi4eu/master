// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

//TODO: Update URL
const BASE_URL: string = 'http://localhost:7001/noah';

export const environment = {
    production: false,
    logoutUrl: "https://ecas.acceptance.ec.europa.eu/cas/logout",

    //TODO: Update URL
    url: BASE_URL + '/services/ui/'
};
