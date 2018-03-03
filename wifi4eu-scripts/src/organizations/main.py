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
        # with open(country_code + '.sql', 'w') as f:
        #     for j in range(2, s.nrows):
        #         association = s.row_values(j)[i]
        #             name = unidecode.unidecode(association)
        #             f.write(
        #                 "INSERT INTO " + sys.argv[2] + ".organizations (name, country_code) VALUES ('" + name + "','" + country_code + "');")


if __name__ == '__main__':
    main()
