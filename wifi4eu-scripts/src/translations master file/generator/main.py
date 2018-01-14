import json
import os

import xlsxwriter


# Initialize excel file
def init_worksheet(filename):
    workbook = xlsxwriter.Workbook(filename + '.xlsx')
    worksheet = workbook.add_worksheet()

    bold = workbook.add_format({'bold': True})
    worksheet.write(0, 0, 'Labels', bold)

    return workbook, worksheet, bold


# Parse json file into dictionary
def get_data(filename):
    with open('../translations/' + filename + '.json') as f:
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
        worksheet.write(0, i + 1, filename, bold)

        # Remove labels not present in base file but in translation file
        for key, value in data.items():
            if key not in base_data:
                del data[key]

        # Add labels not present in translation file but in base file
        # Write labels values translated in each language into excel file
        for j, item in enumerate(base_data.items()):
            key = item[0]
            if key not in data:
                data[key] = ''
            if i == 0:
                worksheet.write(j + 1, i, key)
            worksheet.write(j + 1, i + 1, data[key])
    workbook.close()


if __name__ == "__main__":
    main()
