public interface ClaimProcessManager {
    boolean add(Claim claim);
    boolean update(Claim claim);
    boolean delete(Claim claim);
    String getOne(String id);
    String getAll();

}
