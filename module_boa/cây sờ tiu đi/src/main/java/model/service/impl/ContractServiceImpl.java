
        package model.service.impl;

        import model.bean.Contract;
        import model.repositories.CategoryRepository;
        import model.repositories.impl.CategoryRepositoryImpl;
        import model.service.CategoryService;

        import java.util.List;

public class ContractServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Contract> findALl() {
        return categoryRepository.findALl();
    }

    @Override
    public Contract findProductById(int id) {
        return null;
    }

    @Override
    public Contract getCategoryById(int id) {
        return null;
    }

}