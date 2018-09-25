update m set m.name = l.display_name
from municipalities as m inner join laus as l on m.lau = l.id;
