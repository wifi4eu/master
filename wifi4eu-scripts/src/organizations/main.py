import unidecode
import xlrd
import sys


def main():
    wb = xlrd.open_workbook('../translations/xlsx2json/translations.xlsx')
    s = wb.sheet_by_index(1)
    id = 0
    with open('organizations.sql', 'w') as f:
        for i in range(s.ncols):
            c = (s.col_values(i)[0]).upper()
            aa = s.col_values(i)[2:]
            for a in aa:
                if len(a) > 0:
                    f.write(
                        "INSERT INTO organizations (id, name, country) VALUES ('" + str(id) + "',N'" + a.strip() + "',N'" + c + "');\n")
                    id += 1
                else:
                    continue


if __name__ == '__main__':
    main()
