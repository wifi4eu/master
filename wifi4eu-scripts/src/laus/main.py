import unidecode
import xlrd
import xlutils.copy
import sys
import json


def check_errors(nuts_code, lau_code, abac_name, display_name):
    return len(nuts_code) <= 0 or len(lau_code) <= 0 or len(abac_name) <= 0 or len(display_name) <= 0


def main():
    r_wb = xlrd.open_workbook(sys.argv[1])
    w_wb = xlutils.copy.copy(r_wb)
    sheets = r_wb.sheets()

    for i, r_sheet in enumerate(sheets):
        laus = []
        w_sheet = w_wb.get_sheet(i)

        with open(r_sheet.name + '.sql', 'w') as f:
            for rownum in range(1, r_sheet.nrows):
                country_code = r_sheet.name
                nuts_code = r_sheet.row_values(rownum)[0]
                if type(r_sheet.row_values(rownum)[1]) is not str:
                    lau_code = str(int(r_sheet.row_values(rownum)[1]))
                else:
                    lau_code = r_sheet.row_values(rownum)[1]
                if len(country_code) == 0 or len(nuts_code) == 0 or len(lau_code) == 0:
                    continue
                abac_name = unidecode.unidecode(r_sheet.row_values(rownum)[3])
                display_name = r_sheet.row_values(rownum)[5]
                display_name = display_name.replace("'", "\''")
                laus.append(display_name)
                w_sheet.write(rownum, 4, abac_name)

                if not check_errors(nuts_code, lau_code, abac_name, display_name):
                    f.write("INSERT INTO " + sys.argv[2] + ".laus (country_code,nuts3,lau1,_change,name1,name2) VALUES ('" + country_code +
                            "','" + nuts_code + "','" + lau_code + "','no',N'" + display_name + "',N'" + display_name.upper() + "');\n")

    w_wb.save('LAU_List_Master_File_v1.0.0.xls')


if __name__ == '__main__':
    main()
