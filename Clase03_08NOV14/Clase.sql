select chr_emplcodigo, vch_emplpaterno, 
vch_emplmaterno, vch_emplnombre, vch_emplciudad, 
vch_empldireccion, vch_emplusuario 
from empleado
where vch_emplusuario = 'lcastro'
and vch_emplclave = 'flaca';

