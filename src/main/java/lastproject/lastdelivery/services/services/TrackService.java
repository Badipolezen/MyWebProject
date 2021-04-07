package lastproject.lastdelivery.services.services;

import lastproject.lastdelivery.data.Order;
import lastproject.lastdelivery.data.Track;
import lastproject.lastdelivery.services.models.TrackServiceModel;

import java.util.List;

public interface TrackService {
    void saveTrack(TrackServiceModel model);
  List<TrackServiceModel> getAll();
  List<TrackServiceModel> findTrackByBarcode(String barcode);
}
