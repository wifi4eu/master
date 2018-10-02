import json
import sys
import re

import xlrd
import javaproperties


def main():
    labels()
    mails()


# get labels from the TMF
def labels():
    workbook = xlrd.open_workbook(sys.argv[1])
    worksheet = workbook.sheets()[0]
    filenameTMF = sys.argv[1]

    m = re.search('-v(.*?).xlsx', filenameTMF)
    if m:
        version = m.group(1)

    langs = worksheet.row(0)[3:]
    labels = worksheet.col_values(1)[2:]

    for i, lang in enumerate(langs):
        filename = lang.value + '.json'
        labels = worksheet.col_values(1)[2:]
        translates = worksheet.col_values(i + 3)[2:]

        data = {"TMFversion": version}
        for j, label in enumerate(labels):
            translation = translates[j]
            if label and len(translation) > 0:
                data[label] = translation

        with open('../translations/' + filename, 'w', encoding='utf8') as json_file:
            json_file.write(json.dumps(
                data, indent=2, separators=(',', ': '), ensure_ascii=False))


# Parse json file into dictionary
def mails():
    workbook = xlrd.open_workbook(sys.argv[1])
    worksheet = workbook.sheets()[2]
    filenameTMF = sys.argv[1]

    m = re.search('-v(.*?).xlsx', filenameTMF)
    if m:
        version = m.group(1)

    langs = worksheet.row(0)[3:]
    labels = worksheet.col_values(1)[2:]

    for i, lang in enumerate(langs):
        filename = 'MailBundle_' + lang.value + '.properties'
        labels = worksheet.col_values(1)[2:]
        translates = worksheet.col_values(i + 3)[2:]

        data = {"TMFversion": version}
        for j, label in enumerate(labels):
            translation = translates[j]
            if label and len(translation) > 0:
                data[label] = translation

        with open('../translations/' + filename, 'w', encoding='utf8') as json_file:
            json_file.write((javaproperties.dumps(data)))
            # json.dumps(data, indent=2, separators=(',', ': '), ensure_ascii=False))


if __name__ == "__main__":
    main()
