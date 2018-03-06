import json
import sys

import xlrd


def main():
    workbook = xlrd.open_workbook(sys.argv[1])
    worksheet = workbook.sheets()[0]
    langs = worksheet.row(0)[3:]
    labels = worksheet.col_values(1)[2:]

    for i, lang in enumerate(langs):
        filename = lang.value + '.json'
        labels = worksheet.col_values(1)[2:]
        translates = worksheet.col_values(i+3)[2:]

        data = {}
        for j, label in enumerate(labels):
            translation = translates[j]
            if label and len(translation) > 0:
                data[label] = translation

        with open('../translations/'+filename, 'w', encoding='utf8') as json_file:
            json_file.write(json.dumps(
                data, indent=2, separators=(',', ': '), ensure_ascii=False))


if __name__ == "__main__":
    main()
