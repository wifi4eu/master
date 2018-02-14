import fileinput
import sys


def replace(file, s):
    i = 1
    for line in fileinput.input(file, inplace=1):
        if s in line:
            line = line.replace(s, str(i))
        sys.stdout.write(line)
        i += 1


def main():
    replace("organizations_azure.sql", "'0'")


if __name__ == "__main__":
    main()
