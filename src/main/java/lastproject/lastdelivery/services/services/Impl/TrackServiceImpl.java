package lastproject.lastdelivery.services.services.Impl;


import lastproject.lastdelivery.data.Order;
import lastproject.lastdelivery.data.Track;
import lastproject.lastdelivery.repositories.TrackRepository;
import lastproject.lastdelivery.services.models.TrackServiceModel;
import lastproject.lastdelivery.services.services.TrackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

@Autowired
    public TrackServiceImpl(TrackRepository trackRepository, ModelMapper modelMapper) {
        this.trackRepository = trackRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveTrack(TrackServiceModel model) {
        Track track = this.modelMapper.map(model, Track.class);

        this.trackRepository.saveAndFlush(track);
    }

    @Override
    public List<TrackServiceModel> getAll() {
        return this.trackRepository.findAll().
                stream()
                .map(tr->this.modelMapper.map(tr,TrackServiceModel.class)).
                collect(Collectors.toList());
    }

    @Override
    public List<TrackServiceModel> findTrackByBarcode(String barcode) {
      return this.trackRepository.findAllByBarcode(barcode).stream()
                .map(tr->this.modelMapper.map(tr,TrackServiceModel.class)).collect(Collectors.toList());




    }
}
