import json
import os
import xlsxwriter
import sys
from importlib import reload

reload(sys)


# Initialize excel file
def init_worksheet(filename):
    workbook = xlsxwriter.Workbook(filename + '.xlsx')
    worksheet = workbook.add_worksheet()

    # Light red fill with dark red text.
    format1 = workbook.add_format({'bg_color': '#FFC7CE',
                                   'font_color': '#9C0006'})

    # Light yellow fill with dark yellow text.
    format2 = workbook.add_format({'bg_color': '#FFEB9C',
                                   'font_color': '#9C6500'})

    # Green fill with dark green text.
    format3 = workbook.add_format({'bg_color': '#C6EFCE',
                                   'font_color': '#006100'})

    # Add titles
    bold = workbook.add_format({'bold': True})
    worksheet.write(0, 0, 'Labels', bold)
    worksheet.write(0, 1, 'Count', bold)
    worksheet.write(1, 0, 'Count', bold)

    # Add format conditionals
    # Red if less than 24 translations for a key
    worksheet.conditional_format('B2:B3000', {
                                 'type': 'cell', 'criteria': 'less than', 'value': 24, 'format': format1})
    # Yellow if it is an internal key
    worksheet.conditional_format('A2:A3000', {'type': 'text',
                                              'criteria': 'begins with',
                                              'value': 'int.',
                                              'format': format2})
    # Red if a field is blank
    worksheet.conditional_format(
        'C2:Z3000', {'type': 'blanks', 'format': format1})

    return workbook, worksheet, bold


# Parse json file into dictionary
def get_data(filename):
    with open('../translations/' + filename + '.json', encoding="utf8") as f:
        return json.load(f)


# Filter json data an write into translations master file
def main():
    workbook, worksheet, bold = init_worksheet('translations')

    # Get base data based on English translation file
    # Get all translation files
    base_data = get_data('en')
    files = os.listdir('../translations')

    # Iterate over translation files
    for i, file in enumerate(files):
        filename = os.path.basename('../translations/' + file).split('.')[0]
        data = get_data(filename)

        # Write headers for each translation file
        worksheet.write(0, i + 2, filename, bold)

        # Add vertical counts per language
        worksheet.write(1, i + 2, '=COUNTA(%c3:%c3000)' %
                        (chr(i + 99), chr(i + 99)), bold)

        aux_data = dict(data)
        # Remove labels not present in base file but in translation file
        for key, value in data.items():
            if key not in base_data:
                del aux_data[key]

        # Add labels not present in translation file but in base file
        # Write labels values translated in each language into excel file
        for j, item in enumerate(base_data.items()):
            key = item[0]
            if key not in aux_data:
                aux_data[key] = ''
            if i == 0:
                worksheet.write(j + 2, i, key)
                # Add horizontal counts
                worksheet.write(j + 2, i + 1, '=COUNTA(C%d:ZZ%d)' %
                                (j + 3, j + 3), bold)
            worksheet.write(j + 2, i + 2, aux_data[key])

    workbook.close()


if __name__ == "__main__":
    main()
