package lastproject.lastdelivery.repositories;

import lastproject.lastdelivery.data.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,String> {
    List<Track> findAllByBarcode(String barcode);
}
