package me.cheonhwa.bookyouthspace.status;

import lombok.RequiredArgsConstructor;
import me.cheonhwa.bookyouthspace.book.TimePartRepository;
import me.cheonhwa.bookyouthspace.domain.BookStatusForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStatusService {
    private final TimePartRepository timePartRepository;

    public List<BookStatusForm> getBookStatusFormList() {
        List<BookStatusForm> statusFormList =new ArrayList<>();

        for (int i = 0; i < 14; i++) {

        }
        //오늘 이전
        // 월요일 제외
        //  평일일 경우
        //주말일 경우
        return statusFormList;
    }
}
