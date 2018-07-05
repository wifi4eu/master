from eu.cec.digit.wlst.tools import Importer
from eu.cec.digit.wlst.utils import Utils

# Jython import
import sys

#****f* Creator/main
# FUNCTION
#   main function
# INPUTS
#
# OUTPUTS
#
# EXAMPLE
#
# SOURCE
def main():
    # parse WLST-API command line
    propFiles, userPwd, validateMode = Utils.parseWlstApiCmdLine(sys.argv[1:])

    if (not Utils.empty(propFiles)):        
        Importer.process(propFiles, userPwd, validateMode)

main()