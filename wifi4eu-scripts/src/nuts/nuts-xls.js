var xlsx = require('xlsx');
var jsonfile = require('jsonfile');
var SQLGenerator = require('sql-json-generator');
var sqlGenerator = new SQLGenerator();
var args = process.argv.slice(2);

console.log('[i] functionName ' + args.join(' '));

var lauJson = [];
var nutsJson = [];

var extractNutsJson = function(){

  var workbook = xlsx.readFile('NUTS_2013.xls');

  if(workbook == null){
    console.log("workbook is null");
  }else{

    var sheetNames = workbook.SheetNames;
    sheetNames.forEach(function(sheetName){
      console.log(sheetName);
      var ws = workbook.Sheets[sheetName];
      if(ws == null){
        console.log("worksheet is null");
      }else{
        var wsJson = xlsx.utils.sheet_to_json(ws);
        // jsonfile.writeFile(sheetName+'.json', wsJson, function (err) {
        //   console.error("error creating "+sheetName+".json");
        // });
        // console.log(wsJson[0]);
        nutsJson = nutsJson.concat(wsJson);
      }
    });

  }

}

var extractLauJson = function(){

    var workbook = xlsx.readFile('EU-28_LAU_2016.xlsx');

    if(workbook == null){
      console.log("workbook is null");
    }else{
      var sheetNames = workbook.SheetNames;
      sheetNames.forEach(function(sheetName){
        console.log(sheetName);
        var ws = workbook.Sheets[sheetName];
        if(ws == null){
          console.log("worksheet is null");
        }else{
          var wsJson = xlsx.utils.sheet_to_json(ws);
          // jsonfile.writeFile(sheetName+'.json', wsJson, function (err) {
          //   console.error("error creating "+sheetName+".json");
          // });
          // console.log(wsJson[0]);
          lauJson = lauJson.concat(wsJson);
        }
      });

    }
}

var transformNutsXlsToJson = function(){
  console.log('[i] transformNutsXlsToJson');

  extractNutsJson();

  if(nutsJson != null){
    jsonfile.writeFile('nuts.json', nutsJson, function (err) {
      console.error("error creating nuts.json");
    });
  }else{
    console.log("nutsJson is null");
  }

  console.log('[f] transformNutsXlsToJson');
}

var transformNutsXlsToSql = function (){

  console.log('[i] transformNutsXlsToSql');
    extractNutsJson();

    if(nutsJson != null){

      var nutsSql = '';

      nutsJson.forEach(function(nutsItem){
        var sqlParams = {
            $insert: 'nuts',
            $values : nutsItem
        }
        var sql = sqlGenerator.insert(sqlParams);
        nutsSql = nutsSql + '\n' + sql;
      });

      jsonfile.writeFile('nuts.sql', nutsSql, function (err) {
        console.error("error creating nuts.sql");
      });
    }
    console.log('[f] transformNutsXlsToSql');
}

var transformLauXlsToJson = function(){
  console.log('[i] transformLauXlsToJson');

  extractLauJson();

  if(lauJson != null){
    jsonfile.writeFile('lau.json', lauJson, function (err) {
      console.error("error creating lau.json");
    });
  }

  console.log('[f] transformLauXlsToJson');
}

var transformLauXlsToSql = function (){

  console.log('[i] transformLauXlsToSql');
    extractLauJson();

    if(lauJson != null){

      var lauSql = '';

      lauJson.forEach(function(lauItem){
        var sqlParams = {
            $insert: 'lau',
            $values : lauItem
        }
        var sql = sqlGenerator.insert(sqlParams);
        lauSql = lauSql + '\n' + sql;
      });



      jsonfile.writeFile('lau.sql', lauSql, function (err) {
        console.error("error creating lau.sql");
      });
    }
    console.log('[f] transformLauXlsToSql');
}

var init = function(functionName){
  if(functionName == "transformLauXlsToJson"){
    transformLauXlsToJson();
  }else if(functionName=="transformLauXlsToSql"){
    transformLauXlsToSql();
  }else if(functionName=="transformNutsXlsToJson"){
    transformNutsXlsToJson();
  }else if(functionName=="transformNutsXlsToSql"){
    transformNutsXlsToSql();
  }else if(functionName=="test"){
    console.log('test');
  }else{
    transformNutsXlsToJson();
    transformNutsXlsToSql();
    transformLauXlsToJson();
    transformLauXlsToSql();
  }
}

init(args);

console.log('[f] functionName ' + args.join(' '));
