update m set m.name = l.name_national
from municipalities as m inner join laus as l on m.lau = l.id;
