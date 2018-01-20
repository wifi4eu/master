import json
import os
import re

parent = "."
extensions = ['html', 'js', 'ts']
ignore_dirs = ['wifi4eu-financial', 'node_modules', 'target', 'dist']
regex = r"\{\{(.*?)\|"
base_file = 'en.json'


def add_file_labels(f, labels):
    for line in f:
        matches = re.finditer(regex, line, re.MULTILINE | re.DOTALL)
        for match in matches:
            label = ''.join(match.group(1).split()).split('|')[0].replace("'", '')
            if label not in labels:
                labels.append(label)


def ignore_path(path):
    for dir in ignore_dirs:
        if dir in path:
            return True
    return False


def get_data_from_file(file):
    with open(file, encoding="utf8") as f:
        return json.load(f)


def get_base_data(used_labels):
    base_data = get_data_from_file(base_file)

    # Delete labels no longer used
    old = 0
    aux_data = dict(base_data)
    for label, value in base_data.items():
        if label not in used_labels:
            del aux_data[label]
            old += 1
    base_data = aux_data

    print('Labels deprecated in base translation file (' + base_file + '):', old)

    # Add labels without text
    new = 0
    for label in used_labels:
        if label not in base_data:
            print('"' + label + '":"",')
            base_data[label] = ''
            new += 1

    print('Labels not present in base translation file (' + base_file + '):', new)
    return base_data


# Get labels present in the portal
def get_portal_labels():
    labels = []
    for root, dirs, files in os.walk(parent):
        for file in files:
            path = os.path.join(root, file)
            for extension in extensions:
                if file.endswith('.' + extension) and not ignore_path(path):
                    with open(path) as f:
                        add_file_labels(f, labels)
    return labels


def main():
    used_labels = get_portal_labels()
    base_data = get_base_data(used_labels)
    print('Labels defined in portal:', used_labels)
    print('Labels in base translation file:', base_data)


if __name__ == "__main__":
    main()
