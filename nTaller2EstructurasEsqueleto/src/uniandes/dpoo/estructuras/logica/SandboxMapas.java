package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> valores = new ArrayList<String>();

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            valores.add(pareja.getValue());
        }

        List<String> valoresOrdenados = new ArrayList<String>();

        while(valores.size() > 0)
        {
            int posicionMenor = 0;

            for(int i = 1; i < valores.size(); i++)
            {
                if(valores.get(i).compareTo(valores.get(posicionMenor)) < 0)
                {
                    posicionMenor = i;
                }
            }

            String valorMenor = valores.get(posicionMenor);

            valoresOrdenados.add(valorMenor);
            valores.remove(posicionMenor);
        }

        return valoresOrdenados;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> llaves = new ArrayList<String>();

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            llaves.add(pareja.getKey());
        }

        List<String> llavesOrdenadas = new ArrayList<String>();

        while(llaves.size() > 0)
        {
            int posicionMayor = 0;

            for(int i = 1; i < llaves.size(); i++)
            {
                if(llaves.get(i).compareTo(llaves.get(posicionMayor)) > 0)
                {
                    posicionMayor = i;
                }
            }

            String llaveMayor = llaves.get(posicionMayor);

            llavesOrdenadas.add(llaveMayor);
            llaves.remove(posicionMayor);
        }

        return llavesOrdenadas;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        String primeraLlave = null;

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            String llaveActual = pareja.getKey();

            if(primeraLlave == null || llaveActual.compareTo(primeraLlave) < 0)
            {
                primeraLlave = llaveActual;
            }
        }

        return primeraLlave;
    }
    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        String ultimoValor = null;

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            String valorActual = pareja.getValue();

            if(ultimoValor == null || valorActual.compareTo(ultimoValor) > 0)
            {
                ultimoValor = valorActual;
            }
        }

        return ultimoValor;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        List<String> llavesMayusculas = new ArrayList<String>();

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            String llaveActual = pareja.getKey();

            llavesMayusculas.add(llaveActual.toUpperCase());
        }

        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        List<String> valoresDiferentes = new ArrayList<String>();

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            String valorActual = pareja.getValue();

            boolean yaEsta = false;

            for(int i = 0; i < valoresDiferentes.size(); i++)
            {
                if(valoresDiferentes.get(i).equals(valorActual))
                {
                    yaEsta = true;
                }
            }

            if(!yaEsta)
            {
                valoresDiferentes.add(valorActual);
            }
        }

        return valoresDiferentes.size();
    }
    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
        String cadenaInvertida = "";

        for(int i = cadena.length() - 1; i >= 0; i--)
        {
            cadenaInvertida = cadenaInvertida + cadena.charAt(i);
        }

        mapaCadenas.put(cadenaInvertida, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
        String llaveEliminar = null;

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            if(pareja.getValue().equals(valor))
            {
                llaveEliminar = pareja.getKey();
            }
        }

        if(llaveEliminar != null)
        {
            mapaCadenas.remove(llaveEliminar);
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas = new HashMap<String, String>();

        for(int i = 0; i < objetos.size(); i++)
        {
            String cadenaActual = objetos.get(i).toString();

            agregarCadena(cadenaActual);
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
        Map<String, String> actualizado =
                new HashMap<String, String>();

        for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
        {
            String llaveActual = pareja.getKey();
            String valorActual = pareja.getValue();

            actualizado.put(llaveActual.toUpperCase(), valorActual);
        }

        mapaCadenas = actualizado;
    }
    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        boolean todosEstan = true;

        for(int i = 0; i < otroArreglo.length; i++)
        {
            boolean valorEncontrado = false;

            for(Map.Entry<String, String> pareja : mapaCadenas.entrySet())
            {
                if(pareja.getValue().equals(otroArreglo[i]))
                {
                    valorEncontrado = true;
                }
            }

            if(!valorEncontrado)
            {
                todosEstan = false;
            }
        }

        return todosEstan;
    }

}
