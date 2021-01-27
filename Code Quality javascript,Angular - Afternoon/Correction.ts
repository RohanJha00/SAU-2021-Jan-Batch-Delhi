//Correction File :

import { isReminderSelector,selectedNoteSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';
import { useSelector } from 'react-redux';

import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';


export const noteListSize = 500;
const anotherConst = 0.7;
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;


export const useNoteList = (
  filters,sort,disablePagination,skip: boolean = false,
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);
  const [startIndex, setStartIndex] = useState(initialStartIndex);
  const totalNotes = useRef<number>(0);

  const currentPage = useSubscription(
    GetNotesTabNoteListQuery,
      {
        noteFilters: filters,
      }
  );

  const isCurrentPageEmpty = currentPage.data?.list.length === 0;
  const numPriorItems = currentPage?.data?.numPriorItems ?? 0;
  const prevPageSize = numPriorItems < noteListSize ? numPriorItems : noteListSize;
  const shouldPrevPageLoad = currentPage.data != null && currentPage.data?.numPriorItems > 0 && !disablePagination;

  const randomFunction = useMemo(() => {
  
    const innerlist = currentPage.data
      .concat(
        addDebugInfo(currentPage?.data ?? [], {
          pageName: 'current',
          cached: currentPage === null,
        })
      );
    return innerlist;
  }, [
    disablePagination,
    startIndex,
    currentPage,
    isCurrentPageEmpty,
  ]);

  const result = useMemo(
    () => ({
      ...currentPage.data,
    }),
    [...currentPage]
  );
  return result;
};

function createPlaceholders(count: number, selectedID: string | null): Result {
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        id: undefined,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
  return (placeholders as unknown) as Result;
}

function addDebugInfo(
    list: Result,
    debugInfo: {
      pageName: PageName;
      cached: boolean;
    }
): Result {
    if (debugPagination) {
      return list.map(item => ({ ...item, debugInfo }));
    }
  return list;
}
