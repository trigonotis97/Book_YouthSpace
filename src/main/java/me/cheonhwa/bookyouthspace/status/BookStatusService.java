package me.cheonhwa.bookyouthspace.status;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.TimePartRepository;
import me.cheonhwa.bookyouthspace.domain.DayTimePart;
import me.cheonhwa.bookyouthspace.domain.TimePart;
import me.cheonhwa.bookyouthspace.timepart.TimePartService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStatusService {
    private final TimePartRepository timePartRepository;

    private final TimePartService timePartService;






}
