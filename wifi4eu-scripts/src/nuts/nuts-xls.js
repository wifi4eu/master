var xlsx = require('xlsx');
var jsonfile = require('jsonfile');
var SQLGenerator = require('sql-json-generator');
var sqlGenerator = new SQLGenerator();
var args = process.argv.slice(2);

var jsonOutputPath = './output/json/';
var sqlOutputPath = './output/sql/';

console.log('[i] functionName ' + args.join(' '));

var lauJson = [];
var nutsJson = [];
var organizationsJson = [];
var countryCodes = ['AT', 'BE', 'BG', 'CY', 'CZ', 'DE', 'DK', 'EE',
    'EL', 'ES', 'FI', 'FR', 'HR', 'HU', 'IT', 'IE', 'LT', 'LU', 'LV', 'MT',
    'NL', 'NO', 'PL', 'PT', 'RO', 'SE', 'SI', 'SK', 'UK'];
var validatedCountryCodes = ['AT', 'BE', 'BG', 'CY', 'CZ', 'DE',
    'EL', 'ES', 'FR', 'HU', 'LT', 'LU', 'NL', 'NO', 'PT', 'SE', 'SI', 'SK'];

var extractNutsJson = function () {

    var workbook = xlsx.readFile('./input/NUTS_2013.xls');

    if (workbook == null) {
        console.log("workbook is null");
    } else {

        var sheetNames = workbook.SheetNames;
        sheetNames.forEach(function (sheetName) {
            console.log(sheetName);
            var ws = workbook.Sheets[sheetName];
            if (ws == null) {
                console.log("worksheet is null");
            } else {
                var wsJson = xlsx.utils.sheet_to_json(ws);
                jsonfile.writeFile(jsonOutputPath + sheetName + '.json', wsJson, function (err) {
                    console.error("error creating " + sheetName + ".json");
                });
                //console.log(wsJson[0]);
                nutsJson = nutsJson.concat(wsJson);
            }
        });

    }

}

var extractOrganizationsJson = function () {

    validatedCountryCodes.forEach(function (countryCode) {

        var workbookName = './input/' + countryCode + '_eligible entities_validated.xlsx';
        var workbook = xlsx.readFile(workbookName);

        if (workbook == null) {
            console.log(workbookName + " doesn't exist");
        } else {

            var sheetNames = workbook.SheetNames;
            sheetNames.forEach(function (sheetName) {

                if (sheetName == "Associations") {
                    console.log(workbookName + " has Organizations");

                    var ws = workbook.Sheets[sheetName];
                    if (ws == null) {
                        console.log("worksheet is null");
                    } else {
                        var wsJson = xlsx.utils.sheet_to_json(ws);
                        jsonfile.writeFile(jsonOutputPath + sheetName + '.json', wsJson, function (err) {
                            console.error("error creating " + sheetName + ".json");
                        });
                        //console.log(wsJson[0]);
                        organizationsJson = organizationsJson.concat(wsJson);
                    }

                }

            });

        }

    });


}

var extractLauJson = function () {

    var workbook = xlsx.readFile('./input/EU-28_LAU_2016.xlsx');

    if (workbook == null) {
        console.log("workbook is null");
    } else {
        var sheetNames = workbook.SheetNames;
        sheetNames.forEach(function (sheetName) {
            console.log(sheetName);
            var ws = workbook.Sheets[sheetName];
            if (ws == null) {
                console.log("worksheet is null");
            } else {
                var wsJson = xlsx.utils.sheet_to_json(ws);
                jsonfile.writeFile(jsonOutputPath + sheetName + '.json', wsJson, function (err) {
                    console.error("error creating " + sheetName + ".json");
                });
                //console.log(wsJson[0]);

                var lauSql = '';

                wsJson.forEach(function (lauItem) {
                    var sqlParams = {
                        $insert: 'LOC_LAU_T',
                        $values: lauItem
                    }
                    var sql = sqlGenerator.insert(sqlParams);
                    lauSql = lauSql + ' ' + sql;
                });

                jsonfile.writeFile(jsonOutputPath + sheetName + '.sql', lauSql, function (err) {
                    console.error("error creating location.sql");
                });

                lauJson = lauJson.concat(wsJson);
            }
        });

    }
}

var transformNutsXlsToJson = function () {
    console.log('[i] transformNutsXlsToJson');

    extractNutsJson();

    if (nutsJson != null) {
        jsonfile.writeFile(jsonOutputPath + 'nuts.json', nutsJson, function (err) {
            console.error("error creating nuts.json");
        });
    } else {
        console.log("nutsJson is null");
    }

    console.log('[f] transformNutsXlsToJson');
}

var transformOrganizationsToJson = function () {
    console.log('[i] transformOrganizationsToJson');
    extractOrganizationsJson();

    if (nutsJson != null) {
        jsonfile.writeFile(jsonOutputPath + 'organizations.json', organizationsJson, function (err) {
            console.error("error creating organizations.json");
        });
    } else {
        console.log("nutsJson is null");
    }

    console.log('[f] transformNutsXlsToJson');
}

var transformNutsXlsToSql = function () {

    console.log('[i] transformNutsXlsToSql');
    extractNutsJson();

    if (nutsJson != null) {

        var nutsSql = '';

        nutsJson.forEach(function (nutsItem) {
            var sqlParams = {
                $insert: 'LOC_NUTS_T',
                $values: nutsItem
            }
            var sql = sqlGenerator.insert(sqlParams);
            nutsSql = nutsSql + ' ' + sql;
        });

        jsonfile.writeFile(sqlOutputPath + 'nuts.sql', nutsSql, function (err) {
            console.error("error creating nuts.sql");
        });
    }
    console.log('[f] transformNutsXlsToSql');
}

var transformLauXlsToJson = function () {
    console.log('[i] transformLauXlsToJson');

    extractLauJson();

    if (lauJson != null) {
        jsonfile.writeFile(jsonOutputPath + 'location.json', lauJson, function (err) {
            console.error("error creating location.json");
        });
    }

    console.log('[f] transformLauXlsToJson');
}

var transformLauXlsToSql = function () {

    console.log('[i] transformLauXlsToSql');
    extractLauJson();

    if (lauJson != null) {

        var lauSql = '';

        lauJson.forEach(function (lauItem) {
            var sqlParams = {
                $insert: 'LOC_LAU_T',
                $values: lauItem
            }
            var sql = sqlGenerator.insert(sqlParams);
            lauSql = lauSql + ' ' + sql;
        });


        jsonfile.writeFile(sqlOutputPath + 'location.sql', lauSql, function (err) {
            console.error("error creating location.sql");
        });
    }
    console.log('[f] transformLauXlsToSql');
}

var init = function (functionName) {
    if (functionName == "transformLauXlsToJson") {
        transformLauXlsToJson();
    } else if (functionName == "transformLauXlsToSql") {
        transformLauXlsToSql();
    } else if (functionName == "transformNutsXlsToJson") {
        transformNutsXlsToJson();
    } else if (functionName == "transformNutsXlsToSql") {
        transformNutsXlsToSql();
    } else if (functionName == "extractOrganizationsJson") {
        extractOrganizationsJson();
    } else if (functionName == "test") {
        console.log('test');
    } else {
        transformNutsXlsToJson();
        transformNutsXlsToSql();
        transformLauXlsToJson();
        transformLauXlsToSql();
        transformOrganizationsToJson();
    }
}

init(args);

console.log('[f] functionName ' + args.join(' '));
