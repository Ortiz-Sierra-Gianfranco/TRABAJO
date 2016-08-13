package colegioweb.Interface;

import java.util.List;

/**
 *
 * @author Gianfranco
 * @param <ObjetoDTO>
 */
public interface InterfaceDTO<ObjetoDTO> {

    public boolean create(ObjetoDTO o);

    public boolean delete(Object key);

    public boolean update(ObjetoDTO o);

    public ObjetoDTO read(Object key);

    public List<ObjetoDTO> readAll();

}
