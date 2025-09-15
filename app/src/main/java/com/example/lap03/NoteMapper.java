package com.example.lap03;

import com.google.gson.Gson;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(TextNote note) {
        if (note instanceof TextNote) {
            return new NoteEntity(
                    note.title,
                    "text", null, ((TextNote) note).getTextContent(),
                    note.createdDate
            );
        }
//        } else if (note instanceof CheckListNote) {
//            String jsonItems = gson.toJson(((CheckListNote) note).getItems());
//            return new NoteEntity(note.title, "checklist", jsonItems, null, note.createdDate);
//        }
            return null;
        }

        // Entity -> OOP
        public static TextNote fromEntity(NoteEntity entity) {
            if ("text".equals(entity.type)) {
                return new TextNote(entity.title, entity.createdDate, entity.content);
            }
//        } else if (entity.type.equals("checklist")) {
//            List<String> items = gson.fromJson(entity.checklistItemsJson, new TypeToken<List<String>>(){}.getType());
//            return new CheckListNote(entity.title, entity.createdDate, items);
//        }
                return null;
            }
        }



